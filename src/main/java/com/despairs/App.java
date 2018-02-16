package com.despairs;

import com.despairs.controllers.HeaderController;
import com.despairs.model.Wsdl;
import com.despairs.utils.ResourceDirectory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    private static final String TITLE = "Wsdl generator";
    private static final String RESOURCE_ROOT_DIR = "view";

    private static ResourceDirectory viewsDir = new ResourceDirectory(RESOURCE_ROOT_DIR);

    private static BorderPane rootPane = new BorderPane();
    private static View<HeaderController> headerView = Views.get(ViewType.HEADER);
    private static View currentView;

    public static Wsdl wsdl;

    @Override
    public void start(Stage primaryStage) throws Exception {
        rootPane.setTop(headerView.pane());
        rootPane.centerProperty().addListener((observable, oldValue, newValue) -> headerView.getController().showTitle(currentView.getViewType()));

        show(ViewType.GENERAL_INFO);
        primaryStage.setScene(new Scene(rootPane, 400, 400));
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(Boolean.FALSE);
        primaryStage.show();
    }

    public static void show(ViewType view) {
        currentView = Views.get(view);
        rootPane.setCenter(currentView.pane());
    }

    public static void recreateViews() {
        Views.recreate();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ResourceDirectory getViewsDir() {
        return viewsDir;
    }
}

