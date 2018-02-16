package com.despairs.controllers;

import com.despairs.App;
import com.despairs.ViewType;
import com.despairs.generator.Generator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author EKovtunenko
 */
public class GeneralInfoController extends BaseController {

    @FXML
    private TextField namespaceField;
    @FXML
    private TextField serviceNameField;
    @FXML
    private CheckBox useSameNamespaceBox;
    @FXML
    private TextField xsdNamespaceField;
    @FXML
    private CheckBox generateXsdBox;

    public void onNextButtonClick(ActionEvent event) throws IOException {
        Generator.Builder builder = Generator.newBuilder()
                .withServiceName(serviceNameField.getText())
                .withNamespace(namespaceField.getText());
        if (generateXsdBox.isSelected()) {
            builder.withXsd("TEST?", useSameNamespaceBox.isSelected() ? namespaceField.getText() : xsdNamespaceField.getText());
        }

        Stage stage = getCurrentStage(event);
        stage.setUserData(builder);

        App.show(ViewType.METHOD_LIST);
    }

    public void onGenerateXsdSelect(ActionEvent event) {
        Boolean generateXsdSelected = generateXsdBox.isSelected();
        useSameNamespaceBox.setDisable(!generateXsdSelected);
        enableXsdNamespaceFieldIfNeeded();
    }

    public void onUseSameNamespaceSelect(ActionEvent event) {
        enableXsdNamespaceFieldIfNeeded();
    }

    private void enableXsdNamespaceFieldIfNeeded() {
        Boolean generateXsdSelected = generateXsdBox.isSelected();
        boolean sameNamespaceSelected = useSameNamespaceBox.isSelected();
        xsdNamespaceField.setDisable(sameNamespaceSelected || !generateXsdSelected);
    }
}
