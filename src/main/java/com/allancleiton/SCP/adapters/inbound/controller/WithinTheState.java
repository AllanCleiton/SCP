package com.allancleiton.SCP.adapters.inbound.controller;

import com.allancleiton.SCP.adapters.inbound.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class WithinTheState implements Initializable {
    @FXML
    private TextField txtOrderCharger;
    @FXML
    private Button btnGenerate;
    @FXML
    private Button btnRefactor;
    @FXML
    ScrollPane scrollPaneLeft;
    @FXML
    TableView<Separation> tableView;
    @FXML
    TableColumn<Separation, String> tableColumnOrder;
    @FXML
    TableColumn<Separation, Button> tableColumnAction1;
    @FXML
    TableColumn<Separation, Button> tableColumnAction2;

    @FXML
    public void OnActionBtnGenerate(){
        if(!txtOrderCharger.getText().isEmpty()) {
            IO.println("Orde: " + txtOrderCharger.getText());
        }
    }

    @FXML
    public void deleteSeparation(){

    }

    @FXML
    public void onActionBtnRefactor(){
        IO.println("Desfez");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
        scrollPaneLeft.setFitToHeight(true);
        scrollPaneLeft.setFitToWidth(true);

        Constraints.setTextFieldInteger(txtOrderCharger);
        Constraints.setTextFieldMaxLength(txtOrderCharger,5);
    }

    private void initializeNodes(){
        tableColumnOrder.setCellValueFactory(new PropertyValueFactory<>("orderCharge"));
        tableColumnAction1.setCellValueFactory(new PropertyValueFactory<>("btnAction1"));
        tableColumnAction2.setCellValueFactory(new PropertyValueFactory<>("btnAction2"));

        /*Stage stage = (Stage) SmcpApplication.getMainScene().getWindow();
        tableView.prefHeightProperty().bind(stage.heightProperty());*/

    }
}
