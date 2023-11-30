package lk.ijse.chicagosystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.chicagosystem.model.*;
import lk.ijse.chicagosystem.to.Customer;
import lk.ijse.chicagosystem.to.Feedback;
import lk.ijse.chicagosystem.to.Menu;
import lk.ijse.chicagosystem.to.ReserveTable;
import lk.ijse.chicagosystem.util.DateAndTime;
import lk.ijse.chicagosystem.util.Navigation;
import lk.ijse.chicagosystem.util.Routes;
import lk.ijse.chicagosystem.view.tm.CustomerTM;
import lk.ijse.chicagosystem.view.tm.FeedbackTM;
import lk.ijse.chicagosystem.view.tm.MenuTM;
import lk.ijse.chicagosystem.view.tm.TableReservationTM;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashierFormController implements Initializable {

    private static CashierFormController feedback;
    public AnchorPane menuPane;
    public JFXTextField txtcusId;
    public JFXTextField txtcusName;
    public JFXTextField txtcusContact;
    public JFXTextField txtcusAddress;
    public JFXButton btnReserve;
    public JFXButton btnRemove;
    public ImageView imgWelcome;
    public AnchorPane customerPane;
    public AnchorPane tableReservationPane;
    public AnchorPane feedbackPane;
    public TextField txtfbTitle;
    public TextArea txtDescription;
    public TextField txtRating;
    public TableView tblFeedback;
    public JFXButton btnOrder;
    public JFXButton btnManageCustomer;
    public JFXButton btnFeedback;
    public JFXButton btnReserveTable;
    public AnchorPane miniPane;
    public AnchorPane orderPaneView;
    public JFXButton btnMenu;
    public Label lblDate1;
    public Text txtHour1;
    public TableView tblTableReservation;
    public TableView tblCustomerDetails;
    public TableColumn col1CusID;
    public TableColumn col2CusName;
    public TableColumn col3CusAddress;
    public TableColumn col4CusContact;
    public ComboBox cmbTableNo;
    public TextField txtCusName;
    public TextField txtMenuItemNo;
    public TextField txtMenuItemName;
    public TextField txtPrice;
    public ComboBox cmbCategory;
    public TableView tblManageMenu;
    public TableColumn colItemCode;
    public TableColumn colItemName;
    public TableColumn colItemPrice;
    public TableColumn colItemCategory;
    public JFXButton btnAdd;
    public Label lblCusID;
    public Label lblCusName;
    public Label lblCusContact;
    public Button btnclearTextFields;
    public Pane showIntroPane;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public ImageView btnRefresh;
    public JFXButton btnNewMenu;
    public TextField txtSearchfield;
    public JFXTextField txtfbNo;
    public Text txtoId;
    public JFXDatePicker datePicker;
    public Label lbltblReserveCusID;
    public TextField txtCusContact;
    public Text txtNoOfSeats;
    public Text txtNoOfSeats1;
    public JFXButton btnskipButton;
    public TableColumn tblTableReservationColCustId;
    public TableColumn tblTableReservationColTableNo;
    public TableColumn tblTableReservationColNoOfSeats;
    public TableColumn tblTableReservationColCusName;
    public TableColumn tblTableReservationColReservationStatus;
    public TableColumn tblTableReservationColReservedDate;
    public TableColumn tblFeedbackNo;
    public TableColumn tblFeedbackType;
    public TableColumn tblFeedbackDescription;
    public TableColumn tblFeedbackRate;
    public JFXButton btnClose;
    boolean manageCustomerbtncolor = true;
    boolean reserveTablebtnColor = true;
    boolean orderbtnColor = true;
    boolean feedbackbtncolor = true;
    boolean menubtnColor = true;
    String[] category = {"Rice", "Kottu", "Bite", "FastFood"};

    // -----------------------------Menu-----------------------------
    ObservableList<MenuTM> menuTMS = FXCollections.observableArrayList();

    //    Customer Table
    ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();
    String[] tableNo = {"T01", "T02", "T03", "T04", "T05"};
    String reserved = "Reserved";

    ObservableList<TableReservationTM> reservationList = FXCollections.observableArrayList();

    ObservableList<FeedbackTM> feedbackTMS = FXCollections.observableArrayList();

    public CashierFormController() {
        feedback = this;
    }

    public static CashierFormController getFeedback() {
        return feedback;
    }

    private void clearPnane() {
        orderPaneView.getChildren().clear();
    }

    /* ------------------------- Main Button Actions ----------------------------*/

    public void orderOnAction(ActionEvent actionEvent) throws IOException {
        imgWelcome.setVisible(false);
        customerPane.setVisible(false);
        tableReservationPane.setVisible(false);
        feedbackPane.setVisible(false);
        menuPane.setVisible(false);
        clearPnane();
        Navigation.navigate(Routes.ORDER, orderPaneView);

        if (orderbtnColor) {
            btnOrder.setStyle("-fx-background-color: #2c3e50;-fx-background-radius: 23");
            orderbtnColor = false;
        }
        orderbtnColor = true;

        menubtnColor = true;
        btnMenu.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        manageCustomerbtncolor = true;
        btnManageCustomer.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        reserveTablebtnColor = true;
        btnReserveTable.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        feedbackbtncolor = true;
        btnFeedback.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

    }

    //   ------------------------Menu Section-----------------------------
    public void manageMenuOnAction(ActionEvent actionEvent) {
        clearPnane();
        imgWelcome.setVisible(false);
        tableReservationPane.setVisible(false);
        customerPane.setVisible(false);
        feedbackPane.setVisible(false);
        menuPane.setVisible(true);

        if (menubtnColor) {
            btnMenu.setStyle("-fx-background-color:  #2c3e50;-fx-background-radius: 23");
            menubtnColor = false;
        }
        menubtnColor = true;

        reserveTablebtnColor = true;
        btnReserveTable.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        manageCustomerbtncolor = true;
        btnManageCustomer.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        orderbtnColor = true;
        btnOrder.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        feedbackbtncolor = true;
        btnFeedback.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");
    }

    private void setTableData() {
        tblManageMenu.getItems().clear();
        try {
            ResultSet set = MenuModel.getAll();
            while (set.next()) {
                menuTMS.add(new MenuTM(
                        set.getString(1),
                        set.getString(2),
                        set.getDouble(3),
                        set.getString(4)
                ));
                tblManageMenu.setItems(menuTMS);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    Add New Menu Item
    public void addNewtoMenu(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnNewMenu.getText().equals("NEW")) {
            btnNewMenu.setText("ADD");
            btnNewMenu.setStyle("-fx-background-color: #4374E4");
            txtMenuItemNo.clear();
            txtMenuItemName.clear();
            txtPrice.clear();
            cmbCategory.getItems().clear();
            cmbCategory.getItems().addAll(category);

        } else {
            String menuItemNo = txtMenuItemNo.getText();
            String mItemName = txtMenuItemName.getText();
            double mPriceperOne = Double.valueOf(txtPrice.getText());
            String category = String.valueOf(cmbCategory.getValue());

            Menu menu = new Menu(menuItemNo, mItemName, mPriceperOne, category);

            boolean isAdded = MenuModel.addMenu(menu);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "New Menu Item Added Successful...!").show();
                btnNewMenu.setText("NEW");
                btnNewMenu.setStyle("-fx-background-color: green");
                setTableData();
                txtMenuItemNo.clear();
                txtMenuItemName.clear();
                txtPrice.clear();
                cmbCategory.getItems().clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
            }
        }
    }

    //    Search Menu Item
    public void tfItemCode(ActionEvent actionEvent) {

        String id = txtMenuItemNo.getText();
        try {
            Menu menu = MenuModel.search(id);
            if (menu != null) {
                fillData(menu);
            } else {
                txtMenuItemName.requestFocus();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        setTableData();
    }

    //    Search User Supportive
    public void fillData(Menu menu) {
        txtMenuItemNo.setText(menu.getmItemNo());
        txtMenuItemName.setText(menu.getmItem());
        txtPrice.setText(String.valueOf(menu.getPricePerOne()));
        cmbCategory.setValue(menu.getCategory());

    }

    //   Update Menu Item
    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String mItemNo = txtMenuItemNo.getText();
        String mItemName = txtMenuItemName.getText();
        double Price = Double.parseDouble(txtPrice.getText());
        String category = String.valueOf(cmbCategory.getValue());

        Menu menu = new Menu(mItemNo, mItemName, Price, category);

        boolean isUpdate = MenuModel.Update(menu);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Menu Item Updated Successful...!").show();
            txtMenuItemNo.clear();
            txtMenuItemName.clear();
            txtPrice.clear();
            cmbCategory.getItems().clear();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
        setTableData();
    }

    //   Delete Menu Item
    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete = MenuModel.delete(txtMenuItemNo.getText());

        if (isDelete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Menu Item Deleted Successful...!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
        setTableData();
    }


    // -----------------------------Customer Section-------------------------------
    public void manageCustomerOnAction(ActionEvent actionEvent) {
        clearPnane();
        imgWelcome.setVisible(false);
        tableReservationPane.setVisible(false);
        customerPane.setVisible(true);
        feedbackPane.setVisible(false);
        menuPane.setVisible(false);
        txtcusId.requestFocus();

        if (manageCustomerbtncolor) {
            btnManageCustomer.setStyle("-fx-background-color: #2c3e50;-fx-background-radius: 23");
            manageCustomerbtncolor = false;
        }
        manageCustomerbtncolor = true;

        menubtnColor = true;
        btnMenu.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        reserveTablebtnColor = true;
        btnReserveTable.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        orderbtnColor = true;
        btnOrder.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        feedbackbtncolor = true;
        btnFeedback.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");
    }

    //    Typing Events
    public void checkCusID(KeyEvent keyEvent) {
        Pattern cusIdpattern = Pattern.compile("(C0)([1-9]{0,})");
        Matcher cusIdmatcher = cusIdpattern.matcher(txtcusId.getText());
        boolean isMachedUser = cusIdmatcher.matches();
        if (!isMachedUser) {
            txtcusId.requestFocus();
            txtcusId.setFocusColor(Paint.valueOf("Red"));
            lblCusID.setText("*Invalid Customer ID (Start with - C0)");

        } else {
            txtcusId.setFocusColor(Paint.valueOf("#4059a9"));
            lblCusID.setText("");
        }
    }

    public void checkCusName(KeyEvent keyEvent) {
        if (txtcusName != null) {
            txtcusName.setFocusColor(Paint.valueOf("#4059a9"));
            lblCusName.setText("");
        }
        if (txtcusId.getText().isEmpty()) {
            txtcusId.setFocusColor(Paint.valueOf("Red"));
            lblCusID.setText("*Customer ID Required");

        } else {
            txtcusId.setFocusColor(Paint.valueOf("#4059a9"));
        }

    }

    public void checkContact(KeyEvent keyEvent) {

        if (txtcusContact != null) {
            txtcusContact.setFocusColor(Paint.valueOf("#4059a9"));
            lblCusContact.setText("");
        }

        if (txtcusName.getText().isEmpty()) {
            txtcusName.setFocusColor(Paint.valueOf("Red"));
            lblCusName.setText("*Customer Name Required!");

        }
        if (btnAdd.getText().equals("NEW")) {
            btnAdd.setText("ADD");
        } else {
            txtcusName.setFocusColor(Paint.valueOf("#4059a9"));
            lblCusName.setText("");
        }
    }

    private void clearTextFields() {
        txtcusId.clear();
        txtcusName.clear();
        txtcusAddress.clear();
        txtcusContact.clear();
        lblCusID.setText("");
    }

    //    Add New Customer
    public void addCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (btnAdd.getText().equals("NEW")) {
            btnAdd.setText("ADD");
            nextId();
        } else {
            txtcusId.setEditable(true);
            String cusId = txtcusId.getText();
            String name = txtcusName.getText();
            String address = txtcusAddress.getText();
            int contactNo = Integer.parseInt(txtcusContact.getText());

            Customer customer = new Customer(cusId, name, address, contactNo);

            final boolean isAdded = CustomerModel.addCustomer(customer);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "New Customer Added Successful...!").show();
                clearTextFields();
                btnAdd.setText("NEW");
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
            }
        }
        setCustomerData();
    }

    public void cusNameOnAction(ActionEvent actionEvent) {
        if (lblCusID.getText().equals("No Customer On This ID. Fill below Details to ADD")) {
            lblCusID.setText("");
        }
        txtcusAddress.requestFocus();
    }

    public void cusAddressOnAction(ActionEvent actionEvent) {
        txtcusContact.requestFocus();
    }

    public void cusContactOnAction(ActionEvent actionEvent) {
        btnAdd.fire();
    }

    //     Next Customer ID Generator
    public void nextId() {
        try {
            ResultSet set = CustomerModel.getLastId();
            if (set.next()) {
                String[] e0s = set.getString(1).split("C0");
                int id = Integer.parseInt(e0s[1]);
                id++;

                txtcusId.setText("C0" + id);
            } else {
                txtcusId.setText("C01");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    Search Customer
    public void cusIDOnAction(ActionEvent actionEvent) {

        String id = txtcusId.getText();
        try {
            Customer customer = CustomerModel.search(id);
            if (customer != null) {
                fillData(customer);
                btnclearTextFields.setVisible(true);
            } else {
                txtcusName.requestFocus();
                lblCusID.setText("No Customer On This ID. Fill below Details to ADD");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //    Search Customer
    public void searchOnAction(ActionEvent actionEvent) {
        String id = txtSearchfield.getText();
        try {
            Customer customer = CustomerModel.search2(id);
            if (customer != null) {
                fillData(customer);
                btnclearTextFields.setVisible(true);
            } else {
                txtcusName.requestFocus();
                lblCusID.setText("No Customer On This ID. Fill below Details to ADD");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchOnAction2(MouseEvent mouseEvent) {
        String id = txtSearchfield.getText();
        try {
            Customer customer = CustomerModel.search2(id);
            if (customer != null) {
                fillData(customer);
                btnclearTextFields.setVisible(true);
            } else {
                txtcusName.requestFocus();
                lblCusID.setText("No Customer On This ID. Fill below Details to ADD");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //    Search Supportive
    public void fillData(Customer customer) {
        txtcusId.setText(customer.getCusId());
        txtcusId.setEditable(false);
        txtcusName.setText(customer.getName());
        txtcusAddress.setText(customer.getAddress());
        txtcusContact.setText(String.valueOf(customer.getContact()));
    }


    // ------------------------Table Reserve Section-----------------------------

    //   Update Customer
    public void updateCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String cusId = txtcusId.getText();
        txtcusId.setEditable(false);
        String name = txtcusName.getText();
        String address = txtcusAddress.getText();
        int contactNo = Integer.parseInt(txtcusContact.getText());

        Customer customer = new Customer(cusId, name, address, contactNo);

        boolean isUpdate = CustomerModel.Update(customer);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated Successful...!").show();
            clearTextFields();
            btnclearTextFields.setVisible(false);
            txtcusId.setEditable(true);
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
        setCustomerData();
    }

    //   Delete Customer
    public void deleteCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete = CustomerModel.delete(txtcusId.getText());

        if (isDelete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted Successful...!").show();
            clearTextFields();
            btnclearTextFields.setVisible(false);
            txtcusId.setEditable(true);
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
        setCustomerData();
    }

    private void setCustomerData() {
        tblCustomerDetails.getItems().clear();
        try {
            ResultSet set = CustomerModel.getAll();
            while (set.next()) {
                customerTMS.add(new CustomerTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4)
                ));
                tblCustomerDetails.setItems(customerTMS);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //   Clear Text Fields
    public void clearOnAction(ActionEvent actionEvent) {
        clearTextFields();
        txtcusId.setEditable(true);
        btnclearTextFields.setVisible(false);
    }

    //    Notify On Label
    public void showOnMpuse(MouseEvent mouseEvent) {
        showIntroPane.setVisible(true);
    }

    //    Notify Off Label
    public void exitOutMouse(MouseEvent mouseEvent) {
        showIntroPane.setVisible(false);
    }

    //    Refresh Text Fields
    public void reFreshOnClick(MouseEvent mouseEvent) {
        clearTextFields();
        txtcusId.setEditable(true);
        lblCusID.setText("");
    }

    public void reserveTableOnAction(ActionEvent actionEvent) {
        setReservationTableData();
        clearPnane();
        imgWelcome.setVisible(false);
        customerPane.setVisible(false);
        tableReservationPane.setVisible(true);
        feedbackPane.setVisible(false);
        menuPane.setVisible(false);

        manageCustomerbtncolor = true;
        btnManageCustomer.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        menubtnColor = true;
        btnMenu.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        if (reserveTablebtnColor) {
            btnReserveTable.setStyle("-fx-background-color: #2c3e50;-fx-background-radius: 23");
            reserveTablebtnColor = false;
        }
        reserveTablebtnColor = true;

        orderbtnColor = true;
        btnOrder.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        feedbackbtncolor = true;
        btnFeedback.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

    }

    public void ReserveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String tblNo1 = String.valueOf(cmbTableNo.getValue());
        String customer = txtCusContact.getText();
        int noOfSeats = Integer.parseInt(txtNoOfSeats.getText());
        LocalDate resDate = datePicker.getValue();
        String reservationStatus = reserved;
        String customerName = txtCusName.getText();

        ReserveTable reserveTable = new ReserveTable(tblNo1, customer, noOfSeats, resDate, reservationStatus, customerName);

        boolean isAdded = TableModel.addTableData(reserveTable);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Table Reserved Successful...!").show();
            setReservationTableData();

            txtCusContact.clear();
            txtCusName.clear();
//            cmbTableNo.getItems().clear();
            lblCusContact.setText("");
            datePicker.setValue(null);

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }

        lblCusContact.setText("");
        txtNoOfSeats.setText("");

    }


    //Reservation Table Items ****************

    public void RemoveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean isDelete = TableModel.delete(cmbTableNo.getValue().toString());

        if (isDelete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Booking Removed Successful...!").show();
            setReservationTableData();
            txtCusContact.clear();
            txtCusName.clear();
//            cmbTableNo.getItems().clear();
            lblCusContact.setText("");

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
        lblCusContact.setText("");
        txtNoOfSeats.setText("");
    }

    public void addNewCustomer(ActionEvent actionEvent) {
        tableReservationPane.setVisible(false);
        customerPane.setVisible(true);
    }

    //T number select Combo Box
    public void selectOnActionComboBox(ActionEvent actionEvent) {
        cmbTableNo.getValue();
        if (cmbTableNo.getValue().equals("T01")) {
            txtNoOfSeats.setText("8");
        } else if (cmbTableNo.getValue().equals("T02")) {
            txtNoOfSeats.setText("10");
        } else if (cmbTableNo.getValue().equals("T03")) {
            txtNoOfSeats.setText("5");
        } else if (cmbTableNo.getValue().equals("T04")) {
            txtNoOfSeats.setText("2");
        } else if (cmbTableNo.getValue().equals("T05")) {
            txtNoOfSeats.setText("14");
        } else {
            new Alert(Alert.AlertType.WARNING, "Select Table !").show();
        }
    }

    private void setReservationTableData() {

        tblTableReservation.getItems().clear();
        try {
            ResultSet set = TableModel.getAll2();
            int i = 0;
            while (set.next()) {

                reservationList.add(
                        new TableReservationTM(
                                set.getString(2),
                                set.getString(1),
                                set.getString(3),
                                set.getString(6),
                                set.getString(5),
                                set.getString(4)
                        ));
                System.out.println(reservationList.get(i).getCusId());
                i++;
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        tblTableReservation.refresh();

    }

    public void searchCusContactOnAction(ActionEvent actionEvent) {

        String id = txtCusContact.getText();
        try {
            Customer customer = CustomerModel.search2(id);
            if (customer != null) {
                fillFields(customer);
            } else {
                txtCusName.requestFocus();
                lbltblReserveCusID.setText("No Customer Under This Contact or ID. To ADD, Click \" New Customer \" ");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillFields(Customer customer) {
        txtCusContact.setText(customer.getCusId());
        txtCusName.setText(customer.getName());
    }

    public void searchCusNameOnAction(ActionEvent actionEvent) {
        String id = txtCusName.getText();
        try {
            Customer customer = CustomerModel.searchCusName(id);
            if (customer != null) {
                fillFields(customer);
            } else {
                lbltblReserveCusID.setText("No Customer Under This Name. To ADD, Click \" New Customer \" ");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //----------------------------- Feedback Section-----------------------------

    public void feedbackOnAction(ActionEvent actionEvent) throws IOException {
        clearPnane();
        imgWelcome.setVisible(false);
        customerPane.setVisible(false);
        tableReservationPane.setVisible(false);
//        Navigation.navigate(Routes.FEEDBACK, feedbackPane);
        feedbackPane.setVisible(true);
        menuPane.setVisible(false);
        fbnextId();

        manageCustomerbtncolor = true;
        btnManageCustomer.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        menubtnColor = true;
        btnMenu.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        reserveTablebtnColor = true;
        btnReserveTable.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        orderbtnColor = true;
        btnOrder.setStyle("-fx-background-color:  linear-gradient(to right, #2c3e50, #4ca1af);-fx-background-radius: 23");

        if (feedbackbtncolor) {
            btnFeedback.setStyle("-fx-background-color: #2c3e50;-fx-background-radius: 23");
            feedbackbtncolor = false;
        }
        feedbackbtncolor = true;
    }

    public void submitOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (FeedbackModel.save(new Feedback(
                Integer.parseInt(txtfbNo.getText()),
                txtfbTitle.getText(),
                txtDescription.getText(),
                Integer.parseInt(txtRating.getText()),
                getLastOrderId()
        ))) {
            new Alert(Alert.AlertType.CONFIRMATION, "Feedback Submitted Successful...!").show();
            setFeedbackTableData();
            fbnextId();
            txtfbTitle.clear();
            txtDescription.clear();
            txtRating.clear();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
    }

    private String getLastOrderId() {
        try {
            ResultSet set = OrderModel.getLastId();
            if (set.next()) {
                return set.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void fbnextId() {
        try {
            ResultSet set = FeedbackModel.getLastId();
            if (set.next()) {
                int id = Integer.parseInt(set.getString(1));
                id++;
                txtfbNo.setText(String.valueOf(id));
            } else {
                txtfbNo.setText("1");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setFeedbackTableData() {
        tblFeedback.getItems().clear();
        try {
            ResultSet set = FeedbackModel.getFeeedback();
            while (set.next()) {
                feedbackTMS.add(new FeedbackTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4)

                ));
            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
    }

    //logout
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == ok) {
            Navigation.swichNavigation("LoginForm.fxml", actionEvent);
        }
    }

    //set Time
    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txtHour1.setText(hour.format(new Date()));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }


    // Initializer
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        data load table

        tblFeedback.setItems(feedbackTMS);
        lblDate1.setText(DateAndTime.dateNow());
        setTime();

        setTableData();
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        colItemCategory.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));


        setReservationTableData();

        tblTableReservationColCustId.setCellValueFactory(new PropertyValueFactory<>("CusId"));
        tblTableReservationColTableNo.setCellValueFactory(new PropertyValueFactory<>("tblNo"));
        tblTableReservationColNoOfSeats.setCellValueFactory(new PropertyValueFactory<>("noOfSeats"));
        tblTableReservationColCusName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        tblTableReservationColReservationStatus.setCellValueFactory(new PropertyValueFactory<>("resrvationStatus"));
        tblTableReservationColReservedDate.setCellValueFactory(new PropertyValueFactory<>("resDate"));
        tblTableReservation.setItems(reservationList);

        setCustomerData();
        col1CusID.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        col2CusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        col3CusAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        col4CusContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));

        setFeedbackTableData();
        tblFeedbackNo.setCellValueFactory(new PropertyValueFactory<>("fbNo"));
        tblFeedbackType.setCellValueFactory(new PropertyValueFactory<>("fbTitle"));
        tblFeedbackDescription.setCellValueFactory(new PropertyValueFactory<>("fbDescription"));
        tblFeedbackRate.setCellValueFactory(new PropertyValueFactory<>("ratings"));

        cmbCategory.getItems().addAll(category);

        cmbTableNo.getItems().addAll(tableNo);
    }

    //  Go to Jasper Report (Skip)
    public void skipOnAction(ActionEvent actionEvent) {
        feedbackPane.setVisible(false);
    }

    public void closeOnAction(ActionEvent actionEvent) {
        customerPane.setVisible(false);
        OrderForm2Controller.getQtyFocus().newCustomer.setVisible(false);
    }

}
