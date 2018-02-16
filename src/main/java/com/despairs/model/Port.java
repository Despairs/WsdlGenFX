package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class Port extends NamedObject {

    private static final String PORT_NAME_PATTERN = "%sPort";
    private static final String ADDRESS_PATTERN = "http://localhost:8080/%s";

    private Binding binding;
    private String address;

    public Port(String serviceName, Binding binding) {
        super(String.format(PORT_NAME_PATTERN, serviceName));
        this.address = String.format(ADDRESS_PATTERN, serviceName);
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "        <port name=\"" + name + "\" binding=\"tns:" + binding.getName() + "\">\n" +
                "            <soap:address location=\"" + address + "\"/>\n" +
                "        </port>";
    }
}
