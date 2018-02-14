package com.despairs;

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
public class DirectoryChooserController {
    @FXML
    public TextField directoryPathField;
    @FXML
    public Button browseButton;

    public void onBrowseAction(ActionEvent event) {
        Stage stage = (Stage) directoryPathField.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Directory to save WSDL");
        File selectedDirectory = chooser.showDialog(stage);
        if (selectedDirectory != null) {
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }

    public void onGenerateAction(ActionEvent event) throws FileNotFoundException {
        Generator.Builder builder = (Generator.Builder) directoryPathField.getScene().getWindow().getUserData();
        Generator generator = builder.build();
        String path = directoryPathField.getText();
        String wsdlPath = path + "/" + generator.getServiceName() + ".wsdl";
        String xsdPath = path + "/" + generator.getServiceName() + ".xsd";
        generator.generateWsdl(new PrintStream(new File(wsdlPath)));
        generator.generateXsd(new PrintStream(new File(xsdPath)));
    }
}
