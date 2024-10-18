public class Grocery {

    private String name;
    private double price;
    private String experationDate;

    public Grocery() {
    }

    public Grocery(String name, double price, String experationDate) {
        this.name = name;
        this.price = price;
        this.experationDate = experationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExperationDate() {
        return experationDate;
    }

    public void setExperationDate(String experationDate) {
        this.experationDate = experationDate;
    }

    public String getDetails() {
        return "Grocery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", experationDate='" + experationDate + '\'' +
                '}';
    }
}
