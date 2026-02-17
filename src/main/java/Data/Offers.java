package Data;

public class Offers {
    private String name;
    private double price;
    private int discount;

    public Offers(String name, double price, int discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getDiscount() { return discount; }
}

