package com.despairs;

import com.despairs.utils.ResourceDirectory;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    private static ResourceDirectory viewsDir = new ResourceDirectory("view");

    private static BorderPane generalPane = new BorderPane();
    private static View currentView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        currentView = new View(ViewType.GENERAL_INFO);
        generalPane.setTop(new View(ViewType.HEADER).toPane());
        generalPane.setBottom(new View(ViewType.FOOTER).toPane());
        generalPane.setCenter(currentView.toPane());

        primaryStage.setTitle("Wsdl generator");
        primaryStage.setScene(new Scene(generalPane, 400, 400));
        primaryStage.show();
    }

    public static ResourceDirectory getViewsDir() {
        return viewsDir;
    }

    public static void setCenterView(ViewType view) {
        currentView = new View(view);
        generalPane.setCenter(currentView.toPane());
    }

    public static void main(String[] args) {
        launch(args);
    }

}

