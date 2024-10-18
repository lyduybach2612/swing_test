import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    Connection con;

    public Connection getCon(){

        String connectionString = "jdbc:sqlserver://LAPTOP-RT1ETNCP\\LYDUYBACH;" +
                "database=test;" +
                "username=sa;" +
                "password=bach2612;" +
                "encrypt=true" +
                "trustServerCertificate=true";
        try{
            con = DriverManager.getConnection(connectionString);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return con;

    }

    public List<Order> getAllOrders(){

        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT * " +
                "FROM orders INNER JOIN customer ON orders.customer_id = customer.id " +
                "INNER JOIN grocery ON grocery.order_id = orders.id ";
        Statement stmt = null;
        con = getCon();
        try {

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Order order = new Order();
                order.setOrder_id(rs.getString(1));
                Customer customer = new Customer();
                customer.setId(rs.getString(2));
                customer.setName(rs.getString(3));
                order.setCustomer(customer);
                Grocery grocery = new Grocery();
                grocery.setName(rs.getString(5));
                grocery.setPrice(rs.getDouble(6));
                grocery.setExperationDate(rs.getString(7));
                order.addItem(grocery);
                orders.add(order);

            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return orders;

    }

    public void deleteOrderById(int order_id){
        String query = "DELETE FROM orders WHERE order_id = ?";
        PreparedStatement stmt = null;
        con = getCon();
        try {
            stmt = con.prepareStatement(query);
            stmt.setInt(1, order_id);
            stmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Order> getOrdersByCustomer(int customer_id){

        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT * " +
                "FROM orders INNER JOIN customer ON orders.customer_id = customer.id " +
                "INNER JOIN grocery ON grocery.order_id = orders.id " +
                "WHERE orders.customer_id = ?";
        con = getCon();
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Order order = new Order();
                order.setOrder_id(rs.getString(1));
                Customer customer = new Customer();
                customer.setId(rs.getString(2));
                customer.setName(rs.getString(3));
                order.setCustomer(customer);
                Grocery grocery = new Grocery();
                grocery.setName(rs.getString(5));
                grocery.setPrice(rs.getDouble(6));
                grocery.setExperationDate(rs.getString(7));
                order.addItem(grocery);
                orders.add(order);

            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return orders;

    }

    public void updateOrder(Order order, String orderId){

        String query = "UPDATE orders SET id = ?, customer_id = ? WHERE order_id = ?";
        con = getCon();
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, order.getOrder_id());
            ps.setString(2, order.getCustomer().getId());
            ps.setString(3, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
