package com.despairs.controllers;

import com.despairs.App;
import com.despairs.ViewType;
import com.despairs.model.Xsd;
import com.despairs.utils.FileWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * @author EKovtunenko
 */
public class SaveResultController extends BaseController {
    @FXML
    public TextField directoryPathField;
    @FXML
    public Button browseButton;

    public void onBrowseAction(ActionEvent event) {
        Stage stage = getCurrentStage(event);

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Directory to save WSDL");
        File selectedDirectory = chooser.showDialog(stage);
        if (selectedDirectory != null) {
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }

    public void onGenerateAction(ActionEvent event) throws FileNotFoundException {
        String path = directoryPathField.getText();
        String serviceName = App.wsdl.getServiceName();

        String wsdlPath = path + "/" + serviceName + ".wsdl";
        String xsdPath = path + "/" + serviceName + ".xsd";

        FileWriter.write(App.wsdl, wsdlPath);
        FileWriter.write(new Xsd(App.wsdl), xsdPath);
        
        showDialog();
    }

    private void showDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Wsdl and XSD generated");
        alert.setContentText(String.format("Files generated at %s.\nDo you want generate another one?", directoryPathField.getText()));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            App.wsdl = null;
            App.recreateViews();
            App.show(ViewType.GENERAL_INFO);
        } else {
            System.exit(0);
        }
    }

    public void onBackButtonAction(ActionEvent event) {
        App.show(ViewType.METHOD_LIST);
    }
}
