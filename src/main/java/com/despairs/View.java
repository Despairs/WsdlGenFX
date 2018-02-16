package com.despairs;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

/**
 * @author EKovtunenko
 */
public class View<T> {

    private final ViewType viewType;
    private T controller;
    private Pane pane;

    public View(ViewType viewType) {
        this.viewType = viewType;
        init(viewType.name());
    }

    private void init(String id) {
        try {
            String fxml = resolveFxml(id);
            loadPane(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String resolveFxml(String id) throws IOException {
        return App.getViewsDir().ls().stream()
                .filter(s -> s.toUpperCase().contains(id.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find fxml for id " + id));
    }

    private void loadPane(String fxml) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource(fxml);
        FXMLLoader loader = new FXMLLoader(resource);
        pane = loader.load();
        controller = loader.getController();
    }

    public Pane pane() {
        return pane;
    }

    public ViewType getViewType() {
        return viewType;
    }

    public T getController() {
        return controller;
    }
}
