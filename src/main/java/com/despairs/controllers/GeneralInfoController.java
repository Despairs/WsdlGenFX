package com.despairs.controllers;

import com.despairs.App;
import com.despairs.ViewType;
import com.despairs.model.Wsdl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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
    private TextField faultNameField;

    public void onNextButtonClick(ActionEvent event) {
        App.wsdl = new Wsdl(serviceNameField.getText(), namespaceField.getText(), xsdNamespaceField.getText(), faultNameField.getText());
        App.show(ViewType.METHOD_LIST);
    }

    public void onUseSameNamespaceSelect(ActionEvent event) {
        boolean sameNamespaceSelected = useSameNamespaceBox.isSelected();
        xsdNamespaceField.setDisable(sameNamespaceSelected);
    }
}
