package itecafe2;

import static itecafe2.Items.*;
import static itecafe2.command.*;
import static itecafe2.ItemsInstance.*;

public class ITECafe2 {

    public static void main(String[] args) {
        itemsInstance();//アイテムリストをインスタンス化
        getMenu(); //メニュー表示
        order();//購入を実行
    }
}
