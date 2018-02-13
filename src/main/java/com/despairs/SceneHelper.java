package com.despairs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * @author EKovtunenko
 */
public class SceneHelper {
    public static Scene create(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getClassLoader().getResource(fxml));
        return new Scene(root, 350, 275);
    }
}
