package com.despairs;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

/**
 * @author EKovtunenko
 */
public class View {

    private final ViewType viewType;
    private Pane pane;

    public View(ViewType viewType) {
        this.viewType = viewType;
        init(viewType.name());
    }

    private void init(String id) {
        try {
            String fxml = resolveFxml(id);
            pane = loadPane(fxml);
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

    private Pane loadPane(String fxml) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource(fxml);
        return FXMLLoader.load(resource);
    }

    public Pane toPane() {
        return pane;
    }

    public ViewType getViewType() {
        return viewType;
    }
}
