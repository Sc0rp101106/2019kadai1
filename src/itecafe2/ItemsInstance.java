package itecafe2;
public class ItemsInstance {

    public static void itemsInstance() {
        Items hotcoffee = new Items(1, 1, "ホットコーヒー", 280, 330, true);// no,name,price
        Items tea = new Items(2, 1, "   紅茶", 260, 310, true);
        Items icecoffee = new Items(3, 1, "アイスコーヒー", 200, 250, 300, true);// no,name,price
        Items icetea = new Items(4, 1, "アイスティー", 260, 310, true);
        //スイーツ
        Items shortcake = new Items(5, 2, "ショートケーキ", 400, false);
        Items cheesecake = new Items(6, 2, "チーズケーキ", 400, false);
        Items chocolatecake = new Items(7, 2, "チョコレートケーキ", 450, false);
        Items chocobananaparfait = new Items(8, 2, "チョコバナナパフェ", 390, false);
        Items strawberryparfait = new Items(9, 2, "イチゴパフェ", 390, false);
        //軽食
        Items meeatpasta = new Items(10, 3, "ミートパスタ", 650, false);
        Items mixpizza = new Items(11, 3, "ミックスピザ", 700, false);
        //パン
        Items croissant = new Items(12, 4, "クロワッサン", 180, false);
        Items toastsand = new Items(13, 4, "トーストサンド", 200, false);
        Items frenchtoast = new Items(14, 4, "フレンチトースト", 210, false);
    }
}
