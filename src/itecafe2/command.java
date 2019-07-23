package itecafe2;

import java.util.Scanner;
import static itecafe2.Items.*;
import static itecafe2.buy.*;

public class command {

    public static void getMenu() {
        System.out.println("■■■ITECafeシステム■■■");
        int judge = 1;
        for (int i = 0; i < itemList.size(); i++) {

            if (judge == itemList.get(i).getCategory()) {
                switch (judge) {
                    case 1:
                        System.out.println("[ドリンク]");
                        break;
                    case 2:
                        System.out.println("[スイーツ]");
                        break;
                    case 3:
                        System.out.println("[軽食]");
                        break;
                    case 4:
                        System.out.println("[パン]");
                        break;
                }
                judge = itemList.get(i).getCategory() + 1;
            }
            if (itemList.get(i).isItemtype()) {
                if (itemList.get(i).getSizenum() == 2) {
                    System.out.println(itemList.get(i).getNo() + "." + itemList.get(i).getName() + "(S.￥" + itemList.get(i).getSprice() + "[￥" + itemList.get(i).getSpricet() + "])," + "(M.￥" + itemList.get(i).getMprice() + "[￥" + itemList.get(i).getMpricet() + "])");
                } else if (itemList.get(i).getSizenum() == 3) {
                    System.out.println(itemList.get(i).getNo() + "." + itemList.get(i).getName() + "(S.￥" + itemList.get(i).getSprice() + "[￥" + itemList.get(i).getSpricet() + "])," + "(M.￥" + itemList.get(i).getMprice() + "[￥" + itemList.get(i).getMpricet() + "])," + "(L.￥" + itemList.get(i).getLprice() + "[￥" + itemList.get(i).getLpricet() + "])");
                }
            } else {
                System.out.println(itemList.get(i).getNo() + "." + itemList.get(i).getName() + "(￥" + itemList.get(i).getPrice() + "[￥" + itemList.get(i).getPricet() + "])");
            }
        }
    }

    public static void order() {
        int getNumTmp = itemGetNum();
        getNumTmp = itemEnable(getNumTmp);
        itemSizeSelect(getNumTmp);
    }

    public static int itemGetNum() {
        int outNum = 0;
        while (true) {
            try {
                System.out.print("商品番号を入力してください(※数字で入力してください)：");
                Scanner scan = new Scanner(System.in);
                String num = scan.next();
                outNum = Integer.parseInt(num);
                while (true) {
                    if (outNum <= 0 || outNum >= 15) {
                        System.out.print("1から14までの数字で入力してください：");
                        num = scan.next();
                        outNum = Integer.parseInt(num);
                    } else {
                        break;
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error]:数字を入力してください");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[Error]:正しい数字を入力してください");
            }
        }
        return outNum;
    }

    public static int itemEnable(int num) {
        ITEMCORRECT:
        while (true) {
            System.out.print("ご注文は、" + itemList.get(num - 1).getName() + "でよろしいでしょうか？ (y or n)：");
            Scanner scan = new Scanner(System.in);
            String enable = scan.next();
            switch (enable) {
                case "y":
                case "Y":
                    enable = null;
                    break ITEMCORRECT;
                case "n":
                case "N":
                    num = itemGetNum();
                    enable = null;
                    break;
                default:
                    System.out.println("yまたはnの文字を入力してください");
                    break;
            }
        }
        return num;
    }

    public static void itemSizeSelect(int num) {
        if (itemList.get(num - 1).isItemtype()) {
            OUTER:
            while (true) {
                if (itemList.get(num - 1).getSizenum() == 2) {
                    System.out.print("サイズはどれにしますか？(S,M)：");
                    Scanner scan = new Scanner(System.in);
                    String size = scan.next();
                    switch (size) {
                        case "S":
                        case "s":
                            System.out.println(itemList.get(num - 1).getName() + "Sサイズ値段は、" + (itemList.get(num - 1)).getSprice() + "円です。");
                            itemList.get(num - 1).setBuysize(1);
                            buyItemNum(num);
                            break OUTER;
                        case "M":
                        case "m":
                            System.out.println(itemList.get(num - 1).getName() + "Mサイズ値段は、" + (itemList.get(num - 1)).getMprice() + "円です。");
                            itemList.get(num - 1).setBuysize(2);
                            buyItemNum(num);
                            break OUTER;
                        default:
                            System.out.println("SかMの文字を入力してください");
                            break;
                    }

                } else if (itemList.get(num - 1).getSizenum() == 3) {
                    System.out.print("サイズはどれにしますか？(S,M,L)：");
                    Scanner scan = new Scanner(System.in);
                    String size = scan.next();
                    switch (size) {
                        case "S":
                        case "s":
                            System.out.println(itemList.get(num - 1).getName() + "Sサイズ値段は、" + (itemList.get(num - 1)).getSprice() + "円です。");
                            itemList.get(num - 1).setBuysize(1);
                            buyItemNum(num);
                            break OUTER;
                        case "M":
                        case "m":
                            System.out.println(itemList.get(num - 1).getName() + "Mサイズ値段は、" + (itemList.get(num - 1)).getMprice() + "円です。");
                            itemList.get(num - 1).setBuysize(2);
                            buyItemNum(num);
                            break OUTER;
                        case "L":
                        case "l":
                            System.out.println(itemList.get(num - 1).getName() + "Lサイズ値段は、" + (itemList.get(num - 1)).getLprice() + "円です。");
                            itemList.get(num - 1).setBuysize(3);
                            buyItemNum(num);
                            break OUTER;
                        default:
                            System.out.println("SかMかLの文字を入力してください");
                            break;
                    }

                }
            }
        } else {
            System.out.println(itemList.get(num - 1).getName() + "値段は、" + (itemList.get(num - 1)).getPrice() + "円です。");
            buyItemNum(num);
        }
    }

    public static void buyItemNum(int num) {
        int outBuyNum;
        while (true) {
            try {
                System.out.print("いくつ購入しますか？(※数字で入力してください)：");
                Scanner scan = new Scanner(System.in);
                String buyNum = scan.next();
                outBuyNum = Integer.parseInt(buyNum);
                while (true) {
                    if (outBuyNum == 0) {
                        System.out.print("1以上の数字で入力してください：");
                        buyNum = scan.next();
                        outBuyNum = Integer.parseInt(buyNum);
                    } else {
                        break;
                    }
                }
                itemList.get(num - 1).setBuynum(outBuyNum);
                buyItemList.add(itemList.get(num - 1));
                buyTotalDisplay();
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error]:数字を入力してください");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[Error]:正しい数字を入力してください");
            }
        }
    }

    public static void buyTotalDisplay() {
        int total_tmp = 0;
        for (Items item : buyItemList) {
            switch (item.getBuysize()) {
                case 0:
                    total_tmp += item.getPricet() * item.getBuynum();
                    break;
                case 1:
                    total_tmp += item.getSpricet() * item.getBuynum();
                    break;
                case 2:
                    total_tmp += item.getMpricet() * item.getBuynum();
                    break;
                case 3:
                    total_tmp += item.getLpricet() * item.getBuynum();
                    break;
            }
        }
        System.out.println("合計金額は、" + total_tmp + "円です。");
        ITEMCORRECT:
        while (true) {
            System.out.print("まだ購入を続けますか？(y or n)：");
            Scanner scan = new Scanner(System.in);
            String enable = scan.next();
            switch (enable) {
                case "y":
                case "Y":
                    order();
                    break ITEMCORRECT;
                case "n":
                case "N":
                    select_Payments(total_tmp);
                    break ITEMCORRECT;
                default:
                    System.out.println("yまたはnの文字を入力してください");
                    break;
            }
        }
    }
}
