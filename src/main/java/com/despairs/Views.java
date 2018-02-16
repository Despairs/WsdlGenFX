package com.despairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EKovtunenko
 */
public class Views {

    private static final Map<ViewType, View> views = new HashMap<>();

    static {
        create();
    }

    public static View get(ViewType viewType) {
        View view = views.get(viewType);
        if (view == null) {
            throw new IllegalArgumentException(String.format("View for ViewType %s not found", viewType));
        }
        return view;
    }

    public static void recreate() {
        views.clear();
        create();
    }

    public static void create() {
        for (ViewType vt : ViewType.values()) {
            views.put(vt, new View(vt));
        }
    }
}
