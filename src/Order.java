import java.util.*;

public class Order {

    private String order_id;
    Customer customer;
    List<Grocery> items;

    public Order() {
    }

    public Order(String order_id, Customer customer, List<Grocery> items) {
        this.order_id = order_id;
        this.customer = customer;
        this.items = items;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Grocery> getItems() {
        return items;
    }

    public void setItems(List<Grocery> items) {
        this.items = items;
    }

    public void addItem(Grocery item) {
        this.items.add(item);
    }

    public double getTotalCost(){
        double total = 0;
        for(Grocery item : items){
            total += item.getPrice();
        }
        return total;
    }

}
