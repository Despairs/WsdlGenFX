package com.despairs.controllers;

import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.EventObject;

/**
 * @author EKovtunenko
 */
public class BaseController {

    protected Stage getCurrentStage(EventObject event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }
}
