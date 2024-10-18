import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.List;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {

    private final String[] headers = {"Ten KH", "Ma KH", "Ma Don Hang", "Ma SP", "Ten SP", "Han su dung"};

    private JTextField tf_hoTen, tf_maKH, tf_orderId, tf_itemId, tf_itemName, tf_HSD;
    private JLabel lb_hoTen, lb_maKH,lbl_orderId, lbl_itemId, lbl_itemName, lbl_HSD;
    private JButton btn_update;

    private JPanel panel;
    private JTable table;
    private DefaultTableModel model;

    public GUI() {

        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        initializeComponents();
        this.setVisible(true);

    }

    private void initializeComponents() {

        this.panel = new JPanel(new GridLayout(1,1));
        this.model = new DefaultTableModel(headers, 0);
        this.table = new JTable(model);
        this.panel.add(new JScrollPane(table));
        this.tf_hoTen = new JTextField();
        this.tf_maKH = new JTextField();
        this.tf_orderId = new JTextField();
        this.tf_itemId = new JTextField();
        this.tf_itemName = new JTextField();
        this.tf_HSD = new JTextField();
        this.lbl_orderId = new JLabel("Ma don hang");
        this.lbl_itemId = new JLabel("Ma sp");
        this.lbl_itemName = new JLabel("Ten sp");
        this.lbl_HSD = new JLabel("Han su dung");
        this.lb_maKH = new JLabel("Ma KH");
        this.lb_hoTen = new JLabel("Ten KH");
        this.btn_update = new JButton("Update");

        this.lb_maKH.setBounds(10, 10, 80, 25);
        this.lb_hoTen.setBounds(10, 45, 80, 25);
        this.lbl_orderId.setBounds(10, 80, 80, 25);
        this.lbl_itemId.setBounds(10, 115, 80, 25);
        this.lbl_itemName.setBounds(10, 150, 80, 25);
        this.lbl_HSD.setBounds(10, 185, 80, 25);

        this.tf_maKH.setBounds(100,10,200,25);
        this.tf_hoTen.setBounds(100,45,200,25);
        this.tf_orderId.setBounds(100,80,200,25);
        this.tf_itemId.setBounds(100,115,200,25);
        this.tf_itemName.setBounds(100,150,200,25);
        this.tf_HSD.setBounds(100,185,200,25);
        this.btn_update.setBounds(100,220,80,25);
        this.panel.setBounds(100, 255, 500,350);

        this.add(panel);
        this.add(tf_hoTen);
        this.add(tf_maKH);
        this.add(tf_orderId);
        this.add(tf_itemId);
        this.add(tf_itemName);
        this.add(tf_HSD);
        this.add(lbl_orderId);
        this.add(lbl_itemId);
        this.add(lbl_itemName);
        this.add(lbl_HSD);
        this.add(lb_hoTen);
        this.add(lb_maKH);
        this.add(btn_update);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                OrderDAO dao = new OrderDAO();
                List<Order> orders = dao.getAllOrders();
                for (Order order : orders) {
                    String[] row = {
                            order.getCustomer().getName(),
                            order.getCustomer().getId(),
                            order.getOrder_id()
                    };
                    model.addRow(row);

                }
            }
        });

    }

}
