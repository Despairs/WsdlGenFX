package com.despairs;

import com.despairs.generator.Generator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author EKovtunenko
 */
public class GeneralInfoController {

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

    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Generator.Builder builder = Generator.newBuilder()
                .withServiceName(serviceNameField.getText())
                .withNamespace(namespaceField.getText());
        if (generateXsdBox.isSelected()) {
            builder.withXsd("TEST?", useSameNamespaceBox.isSelected() ? namespaceField.getText() : xsdNamespaceField.getText());
        }
        Stage stage = (Stage) serviceNameField.getScene().getWindow();
        Scene scene = SceneHelper.create("method_list.fxml");
        stage.setScene(scene);
        scene.setUserData(builder);
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
