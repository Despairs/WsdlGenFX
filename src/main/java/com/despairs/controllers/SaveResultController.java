package com.despairs.controllers;

import com.despairs.generator.Generator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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
        Generator.Builder builder = (Generator.Builder) getCurrentStage(event).getUserData();
        Generator generator = builder.build();
        String path = directoryPathField.getText();
        String wsdlPath = path + "/" + generator.getServiceName() + ".wsdl";
        String xsdPath = path + "/" + generator.getServiceName() + ".xsd";
        try (PrintStream stream = new PrintStream(new File(wsdlPath))) {
            generator.generateWsdl(stream);
        }
        try (PrintStream stream = new PrintStream(new File(xsdPath))) {
            generator.generateXsd(stream);
        }
    }
}
