package lk.ijse.chicagosystem.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane mainPane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.mainPane = pane;
        Navigation.mainPane.getChildren().clear();
        Stage window = (Stage) Navigation.mainPane.getScene().getWindow();

        switch (route) {
            case ADMIN:
                window.setTitle("Admin Form");
                initUI("AdminForm.fxml");
                window.setFullScreen(true);
                break;
            case CASHIER:
                window.setTitle("Cashier Form");
                initUI("CashierForm.fxml");
                window.setFullScreen(true);
                break;
            case STOREKEEPER:
                window.setTitle("Store Keeper");
                initUI("StoreKeeperForm.fxml");
                window.setFullScreen(true);
                break;
            case ORDER:
                window.setTitle("Order");
                initUI("OrderForm2.fxml");
                break;
            case FEEDBACK:
                window.setTitle("Feedback");
                initUI("FeedbackForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not Suitable UI Found!").show();
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.mainPane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/chicagosystem/view/" + location)));
    }

    public static void swichNavigation(String url, ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Navigation.class.getResource("/lk/ijse/chicagosystem/view/" + url));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
