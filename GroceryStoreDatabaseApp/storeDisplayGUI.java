import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.lang.String;

public class storeDisplayGUI extends JFrame{

    //declares elements of GUI as instance variables
    private JTextField tableName;
    private JButton displayButton;
    private JTextPane dataField;
    private JPanel basePanel;

    public storeDisplayGUI(String title) {
        //super(title);

        //creates new JTextField, JButton, JTextPane, and JPanel objects.
        //The instance variables are then set equal to these objects
        JFrame theFrame = new JFrame(title);
        theFrame.setSize(400, 800);
        JPanel thePanel = new JPanel();
        JButton newButton = new JButton("This");
        JTextField newField = new JTextField();
        JTextPane newPane = new JTextPane();

        //initialization of objects that are the basic elements of the GUI
        basePanel = thePanel;
        displayButton = newButton;
        tableName = newField;
        dataField = newPane;

        //Sets dimensions for visual elements of the GUI.
        //Also assigns a prompt message to the text field, and assigns a label for the button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayButton.setPreferredSize(new Dimension(200,30));
        displayButton.setBounds(100, 180, 200, 30);
        displayButton.setText("Request Table Contents");
        tableName.setPreferredSize(new Dimension(120,30));
        tableName.setText("Enter Table name");
        dataField.setPreferredSize(new Dimension(1000,300));
        //basePanel.add(displayButton);
        //theFrame.setContentPane(basePanel);
        this.setContentPane(basePanel);
        this.add(tableName);
        this.add(dataField);
        this.add(displayButton);
        this.pack();
        theFrame.pack();

        //defines exactly what code is executed when the button is clicked
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //get user provided text from the text field
                String input = tableName.getText();

                //if the user typed "customers", then get the data from the customer table
                //and place it in the data field
                if (input.equalsIgnoreCase("Customers")) {
                    dataField.setText(getCustomerTable());
                }

                //if the user typed "products", then get the data from the products table
                //and place it in the data field
                else if (input.equalsIgnoreCase("Products")) {
                    dataField.setText(getProductTable());
                }

                //if the user typed "purchases", then get the data from the purchases table
                //and place it in the data field
                else if (input.equalsIgnoreCase("Purchases")) {
                    dataField.setText(getPurchaseTable());
                }
                else {
                    //if the user typed anything else, display an error message
                    dataField.setText("Table not found");
                }

            }
        });
    }
    //creates connection object, which allows this java class to gather
    //data from an SQL database
    private static Connection sqlConnect() {

        Connection sConnect = null;

        try {
            //the string below is the directory to the SQL database, which is supposed to be
            //in the same director as this java class
            String dbloc = "jdbc:sqlite:store.db";

            sConnect = DriverManager.getConnection(dbloc);

        }
        catch (SQLException eXcept) {
            System.out.println(eXcept.getMessage());
        }

        return sConnect;

    }

    private static String getCustomerTable() {

        //the string below is the SQL code for gathering data from the customer table
        String sqlCode = "SELECT Customer_Name, ID_Number, Phone, Address FROM Customers";

        StringBuilder customerTable = null;

        //this try block executes the above SQL statement, then converts the result into
        //a string
        try {
            Statement Tstatement = sqlConnect().createStatement();
            ResultSet resultCode = Tstatement.executeQuery(sqlCode);
            customerTable = new StringBuilder();
            customerTable.append("Customer_Name" + "\t" + "ID_Number" + "\t" + "Phone" + "\t\t" + "Address\n");

            while (resultCode.next()) {
                String piece = resultCode.getString("Customer_Name") + "       " + "\t"
                        + resultCode.getString("ID_Number") + "\t"
                        + resultCode.getString("Phone") + "\t"
                        + resultCode.getString("Address") + "\n";
                customerTable.append(piece);
            }
        }
        catch(SQLException except) {
            System.out.println(except);
        }

        return customerTable.toString();
    }

    private static String getProductTable() {

        StringBuilder productTable = new StringBuilder();
        productTable.append("Product_Name             " + "\t" + "ID_Number" + "\t" + "Quantity" + "\tPrice\n");

        //this try block executes an SQL statement that gets the data from the products table,
        //then converts the result into a string
        try {
            Statement Tstatement = sqlConnect().createStatement();
            ResultSet resultCode2 = Tstatement.executeQuery("SELECT Product_Name, ID_Number, Quantity, Price FROM Products");

            while (resultCode2.next()) {
                String pn = resultCode2.getString("Product_Name");
                String theNew = String.format("%-25s", pn);
                String ID = resultCode2.getString("ID_Number");
                int Q = resultCode2.getInt("Quantity");
                double p = resultCode2.getDouble("Price");

                productTable.append(theNew + "\t" + ID + "\t" + Q + "\t" + p + "\n");
            }

        }
        catch(SQLException except) {
            System.out.println(except);
        }

        return productTable.toString();
    }

    private static String getPurchaseTable() {

        StringBuilder purchaseTable = new StringBuilder();

        purchaseTable.append("Purchased_Products         " + "\t" + "Price" + "\t" + "Product_ID" + "\t" + "Quantity" + "\t" + "Total_Products" + "\t" + "Total_Sales" + "\t" + "Customer_Name" + "\tCustomer_ID" + "\t" + "Date_of_Purchase\n");

        //this try block executes an SQL statement that gets the data from the purchases table,
        //then converts the result into a string
        try {
            Statement Tstatement = sqlConnect().createStatement();
            ResultSet resultCode3 = Tstatement.executeQuery("SELECT Purchased_Products, Price, Product_ID, Quantity_Purchased,"
                + " Total_products, Total_Sales, Customer, Customer_ID, Date_of_Purchase FROM Purchases");

        while (resultCode3.next()) {
            String pp = resultCode3.getString("Purchased_Products");
            String theNew = String.format("%-25s", pp);
            double P = resultCode3.getDouble("Price");
            String pid = resultCode3.getString("Product_ID");
            int qp = resultCode3.getInt("Quantity_Purchased");
            int tp = resultCode3.getInt("Total_Products");
            String tp_string = Integer.toString(tp);
            String new_tp = String.format("%-25s", tp_string);
            double ts = resultCode3.getDouble("Total_Sales");
            String c = resultCode3.getString("Customer");
            String thatNew = String.format("%-20s", c);
            String cid = resultCode3.getString("Customer_ID");
            String cid_string = String.format("%-25s", cid);
            String dop = resultCode3.getString("Date_Of_Purchase");

            purchaseTable.append(theNew + "\t" + P + "\t" + pid + "\t" + qp + "\t" + new_tp + "\t" + ts + "\t" + thatNew + "\t" + cid_string + "\t" + dop + "\n");
        }
        }
        catch (SQLException Except) {
            System.out.println(Except.getMessage());
        }
        return purchaseTable.toString();
    }

    public static void main(String args[]) {

        JFrame thisFrame = new storeDisplayGUI("Grocery Store Items");
        thisFrame.setVisible(true);



    }


}
