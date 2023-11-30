package lk.ijse.chicagosystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.chicagosystem.db.DBConnection;
import lk.ijse.chicagosystem.model.EmployeeModel;
import lk.ijse.chicagosystem.model.SalaryModel;
import lk.ijse.chicagosystem.to.Employee;
import lk.ijse.chicagosystem.to.Salary;
import lk.ijse.chicagosystem.util.CrudUtil;
import lk.ijse.chicagosystem.util.DateAndTime;
import lk.ijse.chicagosystem.util.Navigation;
import lk.ijse.chicagosystem.view.tm.SalaryTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminFormController implements Initializable {
    public Label lblDate;
    public Text txtHour;
    public Label lblEMPID;
    public Label lblC1;
    public Label lblUn;
    public Label lblSalary;
    public Label lblPw;
    public JFXComboBox cmbDesignation;
    public Label lblTime;
    public Label lblDate1;
    public AnchorPane userPane;
    public JFXTextField tfEmpId;
    public JFXTextField tfFName;
    public JFXTextField tfContact;
    public JFXTextField tfUserName;
    public JFXTextField tfPassword;
    public JFXTextField tfAddress;
    public JFXTextField tfSalary;
    public Label lblName;
    public Label lblTotalOrder;
    public Label lblNewCustomers;
    public Label lblEarning;
    public Label lblNoOfVisitors;
    public Pane viewPane;
    public AnchorPane reportPane;
    public AnchorPane salaryPane;
    public ImageView imgWelcome;
    public AreaChart yearlySales;
    public StackedBarChart monthlySales;
    public TableColumn col1EMPID;
    public TableColumn col2Name;
    public TableColumn col3GrossSalary;
    public TableColumn col4TotalDeduction;
    public TableColumn col5NetSalary;
    public JFXButton btnAddNew;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public Button btnclearTextFields;
    public Label lblSalaryError;
    public Label lblAddress;
    public Label lbldesignation;
    public TableView<SalaryTM> tblManageSalary;
    public JFXTextField txtempIDsalary;
    public JFXTextField txtdeductions;
    public Label lblNameOnSalarytm;
    public JFXButton btnGenerate;
    public Label lblGrossSalary;
    public Label lblNetSalary;

    String[] role = {"Owner", "Manager", "Chef", "Waiter", "Staff", "Other"};
    Stage stage = new Stage() ;
    final NumberAxis xAxis = new NumberAxis(1, 31, 1);
    final NumberAxis yAxis = new NumberAxis();
    final AreaChart<Number,Number> ac =
            new AreaChart<>(xAxis,yAxis);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAddNew.setText("NEW");
        setTime();
        lblDate.setText(DateAndTime.dateNow());

        lblEarning.setText("10,500");
        lblNewCustomers.setText("12");
        lblNoOfVisitors.setText("450");
        lblTotalOrder.setText("200");

        yearlySales.setStyle("-fx-background-color: orange");
        monthlySales.setStyle("-fx-background-color: #23f8");



        stage.setTitle("Area Chart Sample");


        ac.setTitle("Temperature Monitoring (in Degrees C)");

        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));

        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(1, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));

        ac.getData().addAll(seriesApril, seriesMay);







        cmbDesignation.getItems().addAll(role);

        noOfCustomers();
        noOfTotalOrders();
        totalEarning();
        noOfVisitors();

//        Salary table data
        setTableData();

        col1EMPID.setCellValueFactory(new PropertyValueFactory<>("empId"));
        col2Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col3GrossSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col4TotalDeduction.setCellValueFactory(new PropertyValueFactory<>("deduction"));
        col5NetSalary.setCellValueFactory(new PropertyValueFactory<>("grossSalary"));
        tblManageSalary.setItems(salaryTMS);
    }



    // Texts Clear
    public void clearTextFields() {
        tfEmpId.clear();
        tfFName.clear();
        tfAddress.clear();
        tfContact.clear();
        cmbDesignation.setValue("");
        tfSalary.clear();
        tfUserName.clear();
        tfPassword.clear();
    }

    //set Time
    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txtHour.setText(hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }

    /* ---------------- Validate Key Events Start ------------------*/

    public void checkEmpID(KeyEvent keyEvent) {
        Pattern empIDpattern = Pattern.compile("(E0)([1-9]{0,})");
        Matcher empIDmatcher = empIDpattern.matcher(tfEmpId.getText());
        boolean isMachedUser = empIDmatcher.matches();
        if (!isMachedUser) {
            tfEmpId.requestFocus();
            tfEmpId.setFocusColor(Paint.valueOf("Red"));
            lblEMPID.setText("*Invalid Employee ID (Start with - E0)");

        } else {
            tfEmpId.setFocusColor(Paint.valueOf("#4059a9"));
            lblEMPID.setText("");
        }
    }

    public void checkEmpName1(KeyEvent keyEvent) {
        if (tfFName != null) {
            tfFName.setFocusColor(Paint.valueOf("#4059a9"));
            lblName.setText("");
        }
        if (tfEmpId.getText().isEmpty()) {
            tfEmpId.setFocusColor(Paint.valueOf("Red"));
            lblEMPID.setText("*Employee ID Required");

        } else {
            tfEmpId.setFocusColor(Paint.valueOf("#4059a9"));
        }

    }

    public void onActionAddress(KeyEvent keyEvent) {
        if (tfAddress != null) {
            tfAddress.setFocusColor(Paint.valueOf("#4059a9"));
            lblAddress.setText("");
        }
        if (tfFName.getText().isEmpty()) {
            tfFName.setFocusColor(Paint.valueOf("Red"));
            lblName.setText("*Employee Name Required");
            lblEMPID.setText("");

        } else {
            tfFName.setFocusColor(Paint.valueOf("#4059a9"));
            lblName.setText("");
        }

    }

    public void cmbclickOnAction(MouseEvent mouseEvent) {
        if (cmbDesignation != null) {
            cmbDesignation.setFocusColor(Paint.valueOf("#4059a9"));
            lbldesignation.setText("");
        }
        if (tfAddress.getText().isEmpty()) {
            tfAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddress.setText("*Address Required");

        } else {
            tfAddress.setFocusColor(Paint.valueOf("#4059a9"));
            lblAddress.setText("");
        }
    }

    public void checkContact1(KeyEvent keyEvent) {
        if (tfContact != null) {
            tfContact.setFocusColor(Paint.valueOf("#4059a9"));
            lblC1.setText("");
        }

        if (cmbDesignation.getItems().isEmpty()) {
            cmbDesignation.setFocusColor(Paint.valueOf("Red"));
            lbldesignation.setText("*You Must Select Designation of Employee !");

        } else {
            cmbDesignation.setFocusColor(Paint.valueOf("#4059a9"));
            lbldesignation.setText("");
        }
    }

    public void checkUN(KeyEvent keyEvent) {
        if (tfUserName != null) {
            tfUserName.setFocusColor(Paint.valueOf("#4059a9"));
            lblUn.setText("");
        }
        if (tfContact.getText().isEmpty()) {
            tfContact.setFocusColor(Paint.valueOf("Red"));
            lblC1.setText("*Contact Number Required");

        } else {
            tfContact.setFocusColor(Paint.valueOf("#4059a9"));
            lblC1.setText("");
        }

    }

    public void checkPW(KeyEvent keyEvent) {
        if (tfPassword != null) {
            tfPassword.setFocusColor(Paint.valueOf("#4059a9"));
            lblPw.setText("");
        }
        if (tfUserName.getText().isEmpty()) {
            tfUserName.setFocusColor(Paint.valueOf("Red"));
            lblUn.setText("*User Name Required");

        } else {
            tfUserName.setFocusColor(Paint.valueOf("#4059a9"));
            lblUn.setText("");
        }

    }

    public void checkSalary(KeyEvent keyEvent) {
        if (tfSalary != null) {
            tfSalary.setFocusColor(Paint.valueOf("#4059a9"));
            lblSalary.setText("");
        }
        if (tfPassword.getText().isEmpty()) {
            tfPassword.setFocusColor(Paint.valueOf("Red"));
            lblPw.setText("*Password Required");

        } else {
            tfPassword.setFocusColor(Paint.valueOf("#4059a9"));
            lblPw.setText("");
        }

    }

    /* ----------------Validate Key Events End ------------------*/


    public void enterOnAction(ActionEvent actionEvent) {
        btnAddNew.fire();
    }

    /*-----------------------User Crud Operation -------------------*/
    //    Add New User
    public void addNewUserOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnAddNew.getText().equals("NEW")) {
            btnAddNew.setText("ADD USER");
            nextId();
        } else {
            tfEmpId.setEditable(true);
            String empId = tfEmpId.getText();
            String name = tfFName.getText();
            String userName = tfUserName.getText();
            String password = tfPassword.getText();
            String address = tfAddress.getText();
            String role = String.valueOf(cmbDesignation.getValue());
            int contactNo = Integer.parseInt(tfContact.getText());
            double salary = Double.parseDouble(tfSalary.getText());

            Employee employee = new Employee(empId, name, userName, password, address, role, contactNo, salary);

            final boolean isAdded = EmployeeModel.save(employee);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "New Employee Added Successful...!").show();
                clearTextFields();
                btnAddNew.setText("NEW");
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
            }
        }
    }

    //    Add New User
    private void nextId() {
        try {
            ResultSet set = EmployeeModel.getLastId();
            if (set.next()) {
                String[] e0s = set.getString(1).split("E0");
                int id = Integer.parseInt(e0s[1]);
                id++;

                tfEmpId.setText("E0" + id);
            } else {
                tfEmpId.setText("E01");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    Update User
    public void updateUserOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String empId = tfEmpId.getText();
        tfEmpId.setEditable(false);
        String name = tfFName.getText();
        String userName = (tfUserName.getText());
        String password = tfPassword.getText();
        String address = tfAddress.getText();
        String role = String.valueOf(cmbDesignation.getValue());
        int contactNo = Integer.parseInt(tfContact.getText());
        double salary = Double.parseDouble(tfSalary.getText());


        Employee employee = new Employee(empId, name, userName, password, address, role, contactNo, salary);

        boolean isUpdate = EmployeeModel.Update(employee);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Update Successful...!").show();
            clearTextFields();
            btnclearTextFields.setVisible(false);
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }

    }

    //    Delete User
    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean isDelete = EmployeeModel.delete(tfEmpId.getText());

        if (isDelete) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successful...!").show();
            clearTextFields();
            btnclearTextFields.setVisible(false);
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
    }

    //    Search User
    public void tfsearchOnAction(ActionEvent actionEvent) {
        String id = tfEmpId.getText();
        try {
            Employee employee = EmployeeModel.search(id);
            if (employee != null) {
                fillData(employee);
                btnclearTextFields.setVisible(true);
            } else {
                tfFName.requestFocus();
                lblEMPID.setText("No Employee On This ID");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //    Search User Supportive
    public void fillData(Employee employee) {
        tfEmpId.setText(employee.getEmpId());
        tfEmpId.setEditable(false);
        tfFName.setText(employee.getName());
        tfUserName.setText(String.valueOf(employee.getUserName()));
        tfPassword.setText(employee.getPassword());
        tfAddress.setText(employee.getAddress());
        cmbDesignation.setValue(employee.getRole());
        tfContact.setText(String.valueOf(employee.getContactNo()));
        tfSalary.setText(String.valueOf(employee.getSalary()));

    }

    //    Clear Texts
    public void clearOnAction(ActionEvent actionEvent) {
        clearTextFields();
        tfEmpId.setEditable(true);
        btnclearTextFields.setVisible(false);
    }


    //    Log Out
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == ok) {
            Navigation.swichNavigation("LoginForm.fxml", actionEvent);
        }


    }

    ObservableList<SalaryTM> salaryTMS = FXCollections.observableArrayList();

    private void setTableData() {
        tblManageSalary.getItems().clear();
        try {
            ResultSet set = SalaryModel.getSalaryDetails();
            while (set.next()) {
                salaryTMS.add(new SalaryTM(
                        set.getString(1),
                        set.getString(2),
                        set.getDouble(3)
                ));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    //Main Button Salary Manage
    public void manageSalaryOnAction(ActionEvent actionEvent) {
        userPane.setVisible(false);
        reportPane.setVisible(false);
        imgWelcome.setVisible(false);
        salaryPane.setVisible(true);
    }

    //Main Button User/Employee Manage
    public void manageUserOnAction(ActionEvent actionEvent) {
        imgWelcome.setVisible(false);
        salaryPane.setVisible(false);
        reportPane.setVisible(false);
        userPane.setVisible(true);
    }

    //Main Button User Reports
    public void reportUserOnAction(ActionEvent actionEvent) {
        userPane.setVisible(false);
        imgWelcome.setVisible(false);
        salaryPane.setVisible(false);
        reportPane.setVisible(true);
        Scene scene  = new Scene(ac,800,600);

        stage.setScene(scene);
        stage.show();
    }

    //Side Button Exit
    public void exitOnAction(ActionEvent actionEvent) {
        ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == ok) {
            System.exit(0);
        }

    }

    // Enter btn Actions
    public void txtENameOnAction(ActionEvent actionEvent) {
        tfAddress.requestFocus();
    }

    public void txtEAddressOnAction(ActionEvent actionEvent) {
        cmbDesignation.requestFocus();
    }

    public void cmbEDesignationOnAction(ActionEvent actionEvent) {
        tfContact.requestFocus();
    }

    public void txtContctOnAction(ActionEvent actionEvent) {
        tfUserName.requestFocus();
    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        tfPassword.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
        tfSalary.requestFocus();
    }



    /* --------------------Salary Section--------------------*/


    //    Search Employee in Salary Field
    public void idsearchOnAction(ActionEvent actionEvent) {
        String id = txtempIDsalary.getText();
        try {
            Employee employee = SalaryModel.search(id);
            if (employee != null) {
                fillData2(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        txtdeductions.requestFocus();
    }

    //    Search Employee Salary Supportive
    public void fillData2(Employee employee) {
        txtempIDsalary.setText(employee.getEmpId());
        lblNameOnSalarytm.setText(employee.getName());
    }

    //Count salary
    public void salarycounter() {
        String id = txtempIDsalary.getText();
        double deduction = Double.parseDouble(txtdeductions.getText());
        double total = 0;
        double grossSalary = 0.0;

        for (SalaryTM tm : salaryTMS) {
            if (tm.getEmpId().equals(id)) {
                grossSalary = tm.getSalary();
                total = grossSalary - deduction;
                tm.setGrossSalary(total);
                tm.setDeduction(deduction);
                tblManageSalary.refresh();
                return;
            }
        }
    }

    public void printSalaryReport(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/chicagosystem/view/reports/Salary_sheet.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void noOfCustomers() {
        try {
            String sql = "SELECT COUNT(*) FROM customer";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int memberCount = result.getInt(1);
                lblNewCustomers.setText(String.valueOf(memberCount));
            }
        } catch (Exception ex) {

        }
    }

    private void noOfTotalOrders() {
        try {
            String sql = "SELECT COUNT(*) FROM orders";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int orderCount = result.getInt(1);
                lblTotalOrder.setText(String.valueOf(orderCount));
            }
        } catch (Exception ex) {

        }
    }

    private void totalEarning() {
        try {
            String sql = "SELECT SUM(amount) FROM orders";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int orderCount = result.getInt(1);
                lblEarning.setText(String.valueOf(orderCount));
            }
        } catch (Exception ex) {

        }
    }

    private void noOfVisitors() {
        try {
            String sql = "SELECT COUNT(cusId) FROM orders";
            ResultSet result = CrudUtil.execute(sql);
            if (result.next()) {
                int orderCount = result.getInt(1);
                lblNoOfVisitors.setText(String.valueOf(orderCount));
            }
        } catch (Exception ex) {

        }
    }

    public void addDatabaseonAction(MouseEvent actionEvent) throws SQLException, ClassNotFoundException {

        ArrayList<Salary> cartDetails = new ArrayList<>();

        for (int i = 0; i < tblManageSalary.getItems().size(); i++) {
            SalaryTM tm = salaryTMS.get(i);
            cartDetails.add(new Salary(tm.getEmpId(), tm.getName(), tm.getSalary(), tm.getDeduction(), tm.getGrossSalary()));

        }
        boolean isAddSalary = SalaryModel.saveSalary(cartDetails);

        if (isAddSalary) {

            new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();

        } else {

            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }
    }

    public void deductionOnAction(ActionEvent actionEvent) {
        btnGenerate.fire();
    }

    public void generateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        salarycounter();
    }

    static double id;
    static double net;

    public void UpdateDBOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String empId = txtempIDsalary.getText();
        String name = lblNameOnSalarytm.getText();
        double salary = id;
        Double deduction = Double.valueOf(txtdeductions.getText());
        Double grossSalary = net;


        Salary salaryUpdate = new Salary(empId, name, salary, deduction, grossSalary);

        boolean isUpdate = SalaryModel.Update(salaryUpdate);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Update Successful...!").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong...!").show();
        }

    }
}

