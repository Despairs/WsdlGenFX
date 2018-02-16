package com.despairs.controllers;

import com.despairs.ViewType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EKovtunenko
 */
public class HeaderController {

    private static final Map<ViewType, String> titles = new HashMap<ViewType, String>() {{
        put(ViewType.GENERAL_INFO, "General info about WSDL");
        put(ViewType.METHOD_LIST, "Methods");
        put(ViewType.SAVE_RESULT, "Choose path to save WSDL");
    }};

    @FXML
    private Label titleField;

    public void showTitle(ViewType viewType) {
        titleField.setText(titles.get(viewType));
    }
}
