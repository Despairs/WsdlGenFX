package com.despairs;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Wsdl generator");
        primaryStage.setScene(SceneHelper.create("general_info.fxml"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
