package com.despairs.controllers;

import com.despairs.App;
import com.despairs.ViewType;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

/**
 * @author EKovtunenko
 */
public class MethodListController extends BaseController {

    @FXML
    private ListView<String> methodListView;
    @FXML
    private TextField methodNameField;

    public void onNextButtonAction(ActionEvent event) throws IOException {
        ObservableList<String> methods = methodListView.getItems();
        App.wsdl.setMethods(methods.toArray(new String[methods.size()]));

        App.show(ViewType.SAVE_RESULT);
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        if (code.equals(KeyCode.DELETE)) {
            String selectedItem = methodListView.getSelectionModel().getSelectedItem();
            methodListView.getItems().remove(selectedItem);
        }
    }

    public void onAddNewMethodClick(ActionEvent event) {
        String text = methodNameField.getText();
        if (text != null) {
            text = text.trim();
            if (!text.isEmpty()) {
                methodListView.getItems().add(text);
            }
        }
        methodNameField.setText(null);
    }

    public void onBackButtonAction(ActionEvent event) {
        App.show(ViewType.GENERAL_INFO);
    }
}
