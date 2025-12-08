package com.allancleiton.SCP.adapters.inbound.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    private TabPane tabPane;
    @FXML
    private MenuItem menuItemWithinTheState;
    @FXML
    private MenuItem menuItemOutOfState;
    @FXML
    private MenuItem menuItemSimple;
    @FXML
    private MenuItem menuItemCustomizable;


    @FXML
    public void initialize() {
        for (Tab tab : tabPane.getTabs()) {
            tab.setClosable(true);
        }
    }

    @FXML
    public void onMenuItemWithinTheState() throws IOException {
        loadTabView("/view/WithinTheState.fxml", "Dentro do Estado");
    }

    @FXML
    public void onMenuItemOutOfState() throws IOException {
        loadTabView("/view/OutOfState.fxml", "Fora do estado");
    }

    private synchronized void loadTabView(String absoluteName, String windowName) throws IOException {
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource(absoluteName)));

        Tab tab = new Tab(windowName); // título da aba
        tab.setContent(root.load());

        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab); // opcional: já selecionar a nova aba
    }
}
