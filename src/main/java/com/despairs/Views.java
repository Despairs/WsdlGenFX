package com.despairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EKovtunenko
 */
public class Views {

    private static final Map<ViewType, View> views = new HashMap<>();

    static {
        for (ViewType vt : ViewType.values()) {
            views.put(vt, new View(vt));
        }
    }

    public static View get(ViewType viewType) {
        View view = views.get(viewType);
        if (view == null) {
            throw new IllegalArgumentException(String.format("View for ViewType %s not found", viewType));
        }
        return view;
    }
}
