package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class Service extends NamedObject {

    private Binding binding;
    private Port port;

    public Service(String name, Binding binding) {
        super(name);
        this.binding = binding;
        this.port = new Port(name, binding);
    }

    @Override
    public String toString() {
        return "    <service name=\"" + name + "\">\n" + port + "\n" +
                "    </service>";
    }
}
