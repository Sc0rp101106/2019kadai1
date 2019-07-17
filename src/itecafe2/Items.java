package itecafe2;

import java.util.ArrayList;

public class Items {

    private int no;
    private int category;
    private String name;
    private int price;
    private int sprice;
    private int mprice;
    private int lprice;
    private int pricet;
    private int spricet;
    private int mpricet;
    private int lpricet;
    private boolean itemtype;
    private final double tax = 1.08;
    private int sizenum; //サイズの種類の数
    private int buynum;
    static ArrayList<Items> itemList = new ArrayList<>();
    static ArrayList<Items> buyItemList = new ArrayList<>();

    public Items(int no, int category, String name, int price, boolean itemtype) { //ドリンク以外
        this.no = no;
        this.category = category;
        this.name = name;
        this.price = price;
        this.itemtype = itemtype;
        this.pricet = (int) (price * tax);
        this.buynum = 0;
        itemList.add(this);
    }

    public Items(int no, int category, String name, int sprice, int mprice, boolean itemtype) {
        this.no = no;
        this.category = category;
        this.name = name;
        this.price = price;
        this.sprice = sprice;
        this.mprice = mprice;
        this.pricet = (int) (price * tax);
        this.spricet = (int) (sprice * tax);
        this.mpricet = (int) (mprice * tax);
        this.itemtype = itemtype;
        this.sizenum = 2;
        this.buynum = 0;
        itemList.add(this);
    }

    public Items(int no, int category, String name, int sprice, int mprice, int lprice, boolean itemtype) {
        this.no = no;
        this.category = category;
        this.name = name;
        this.price = price;
        this.sprice = sprice;
        this.mprice = mprice;
        this.lprice = lprice;
        this.pricet = (int) (price * tax);
        this.spricet = (int) (sprice * tax);
        this.mpricet = (int) (mprice * tax);
        this.lpricet = (int) (lprice * tax);
        this.itemtype = itemtype;
        this.sizenum = 3;
        this.buynum = 0;
        itemList.add(this);
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSprice() {
        return sprice;
    }

    public void setSprice(int sprice) {
        this.sprice = sprice;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }

    public int getLprice() {
        return lprice;
    }

    public void setLprice(int lprice) {
        this.lprice = lprice;
    }

    public boolean isItemtype() {
        return itemtype;
    }

    public int getSizenum() {
        return sizenum;
    }

    public int getPricet() {
        return pricet;
    }

    public int getSpricet() {
        return spricet;
    }

    public int getMpricet() {
        return mpricet;
    }

    public int getLpricet() {
        return lpricet;
    }

    public int getCategory() {
        return category;
    }

    public double getTax() {
        return tax;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

}
