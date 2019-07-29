package itecafe2;

import static itecafe2.Items.*;
import java.util.Scanner;

public class buy {

    static Scanner scan = new Scanner(System.in);
    private static int selpay; //支払い方法
    private static int change; //お釣り
    private static int price_sum;//支払い合計
    private static int cast;//預かり金額

    public static void buy_Select(int price) {
        OUT:
        while (true) {
            try {
                System.out.print("支払い方法どうしますか？(1.現金,2.クレジットカード):");
                String selpay_tmp = scan.next();
                selpay = Integer.parseInt(selpay_tmp);
                switch (selpay) {
                    case 1:
                        item_MoneyBuy(price);
                        break OUT;
                    case 2:
                        item_CreditCardBuy();
                        break OUT;
                    default:
                        System.out.println("1から2の数字を入力してください");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error]:数字を入力してください");
            }
        }
        System.out.println("ありがとうございました。");
        System.out.println("またのご来店をお待ちしております。");
    }

    public static void item_CreditCardBuy() {
        System.out.println("クレジットカードをお預かりします。");
        System.out.println("クレジットカードをお返します。");
        receipt_enable();
    }

    public static void item_MoneyBuy(int price) {
        boolean enable = true;
        price_sum = price;
        OUTER:
        while (enable) {
            System.out.print("合計金額は、" + price + "円です:");
            String money_tmp = scan.next();
            try {
                int money = Integer.parseInt(money_tmp);
                if (price > money) {
                    System.out.print("申し訳ございませんが支払い金額が足りません。");
                    change = 0;
                }
                if (price == money) {
                    change = 0;
                    enable = false;
                    System.out.print(money + "円、ちょうどお預かりします。");
                    receipt_enable();
                    break OUTER;
                }
                if (price < money) {
                    change = money - price;
                    enable = false;
                    cast = money;
                    System.out.println(money + "円、お預かりします。");
                    System.out.println(change + "円のお返しになります。");
                    receipt_enable();
                    break OUTER;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error]:数字を入力してください");

            }
        }
    }

    public static void receipt_enable() {
        OUT:
        while (true) {
            System.out.print("レシートを発行しますか？(y or n)：");
            String receipt_ena = scan.next();
            switch (receipt_ena) {
                case "y":
                case "Y":
                    receipt_ena = null;
                    receipt();
                    break OUT;
                case "n":
                case "N":
                    receipt_ena = null;
                    break OUT;
                default:
                    System.out.println("yまたはnの文字を入力してください");
                    break;
            }
        }
    }

    public static void receipt() {
        System.out.println("\n■■■レシート■■■■");
        for (Items item : buyItemList) {
            switch (item.getBuysize()) {
                case 0:
                    System.out.println("\n・" + item.getName() + " - " + "金額：" + item.getPrice() + "【" + item.getPricet() + "】円 個数：" + item.getBuynum() + "個 合計：" + item.getPricet() * item.getBuynum() + "円");
                    break;
                case 1:
                    System.out.println("\n・" + item.getName() + " - " + "金額：" + item.getSprice() + "【" + item.getSpricet() + "】円 個数：" + item.getBuynum() + "個 合計：" + item.getSpricet() * item.getBuynum() + "円");
                    break;
                case 2:
                    System.out.println("\n・" + item.getName() + " - " + "金額：" + item.getMprice() + "【" + item.getMpricet() + "】円 個数：" + item.getBuynum() + "個 合計：" + item.getMpricet() * item.getBuynum() + "円");
                    break;
                case 3:
                    System.out.println("\n・" + item.getName() + " - " + "金額：" + item.getLprice() + "【" + item.getLpricet() + "】円 個数：" + item.getBuynum() + "個 合計：" + item.getLpricet() * item.getBuynum() + "円");
                    break;
            }
        }
        System.out.println("\n合計金額　　：" + price_sum + " 円");
        if (selpay == 1) {
            System.out.println("お預かり金額：" + cast + " 円");
            System.out.println("お釣り　　　：" + change + " 円");
        }
        System.out.println("\n■■■■■■■■■■■\n");
    }

    public int getChange() {
        return change;
    }
}
