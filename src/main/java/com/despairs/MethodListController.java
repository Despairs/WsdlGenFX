package com.despairs;

import com.despairs.generator.Generator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author EKovtunenko
 */
public class MethodListController {

    @FXML
    private ListView<String> methodListView;
    @FXML
    private TextField methodNameField;

    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) methodNameField.getScene().getWindow();
        Generator.Builder builder = (Generator.Builder) stage.getUserData();
        builder.withMethods(methodListView.getItems());

        App.setCenterView(ViewType.SAVE_RESULT);
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        if (code.equals(KeyCode.DELETE)) {
            String selectedItem = methodListView.getSelectionModel().getSelectedItem();
            methodListView.getItems().remove(selectedItem);
        }
    }

    public void onAddNewMethod(ActionEvent event) {
        String text = methodNameField.getText();
        if (text != null) {
            text = text.trim();
            if (!text.isEmpty()) {
                methodListView.getItems().add(text);
            }
        }
        methodNameField.setText(null);
    }

}
