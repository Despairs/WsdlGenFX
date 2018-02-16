package com.despairs.controllers;

import com.despairs.App;
import com.despairs.ViewType;
import com.despairs.generator.Generator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author EKovtunenko
 */
public class MethodListController extends BaseController {

    @FXML
    private ListView<String> methodListView;
    @FXML
    private TextField methodNameField;

    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Stage stage = getCurrentStage(event);

        Generator.Builder builder = (Generator.Builder) stage.getUserData();
        builder.withMethods(methodListView.getItems());

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

}
