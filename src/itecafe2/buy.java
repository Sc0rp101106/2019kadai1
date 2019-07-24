package itecafe2;

import java.util.Scanner;

public class buy {

    static Scanner scan = new Scanner(System.in);
    private static int selpay; //支払い方法
    private static int change; //お釣り
    private static int point; //ポイントカードのポイント
    private static boolean point_ena; //ポイントカードの所持判定

    public static int buy_Select(int price) {
        ITEMCORRECT:
        while (true) {
            System.out.print("ポイントカードはお持ちでしょうか？(y or n)：");
            Scanner scan = new Scanner(System.in);
            String enable = scan.next();
            switch (enable) {
                case "y":
                case "Y":
                    point_ena = true;
                    enable = null;
                    break ITEMCORRECT;
                case "n":
                case "N":
                    point_ena = false;
                    enable = null;
                    break  ITEMCORRECT;
                default:
                    System.out.println("yまたはnの文字を入力してください");
                    break;
            }
        }
        System.out.print("支払い方法どうしますか？(1.現金,2.クレジットカード):");
        String selpay_tmp = scan.next();
        while (true) {
            try {
                selpay = Integer.parseInt(selpay_tmp);
                switch (selpay) {
                    case 1:
                        change = item_MoneyBuy(price);
                        return change;
                    case 2:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error]:数字を入力してください");
            }
        }
    }
    public static void item_CreditCardBuy(){
        
    }
    public static int item_MoneyBuy(int price) {
        boolean enable = true;
        OUTER:
        while (enable) {
            System.out.print("合計金額は、" + price + "円です:");
            String money_tmp = scan.next();
            try {
                int money = Integer.parseInt(money_tmp);
                if (price > money) {
                    System.out.print("お金が足りません。");
                    change = 0;
                }
                if (price == money) {
                    change = 0;
                    enable = false;
                    break OUTER;
                }
                if (price < money) {
                    change = money - price;
                    enable = false;
                    break OUTER;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error]:数字を入力してください");
                
            }
        }
        return change;
    }

    public static int getPoint() {
        return point;
    }

    public static boolean isPoint_ena() {
        return point_ena;
    }
    
    public int getChange() {
        return change;
    }
}
