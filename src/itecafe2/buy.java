
package itecafe2;

import java.util.Scanner;

public class buy {
     static Scanner scan = new Scanner(System.in);
    private static int selpay;
    private static int change;
    public static void select(){
        
    }
    public static int select_Payments(int price) {
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
                break;
            }
        }
        return change;
    }

    public int getChange() {
        return change;
    }
}
