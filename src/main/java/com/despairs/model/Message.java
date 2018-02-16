package com.despairs.model;

import com.despairs.model.base.NamedObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EKovtunenko
 */
public class Message extends NamedObject {

    protected List<Part> parts = new ArrayList<>();

    public Message(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    <message name=\"").append(name).append("\">\n");
        for (Part part : parts) {
            sb.append(part).append("\n");
        }
        sb.append("    </message>");
        return sb.toString();
    }
}
