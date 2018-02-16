package com.despairs.model;

import com.despairs.model.base.NamedObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EKovtunenko
 */
public class PortType extends NamedObject {

    private static final String PORT_TYPE_NAME_PATTERN = "%sPortType";

    private final List<PortTypeOperation> portTypeOperations = new ArrayList<>();

    public PortType(String serviceName, String faultName, String... methods) {
        super(String.format(PORT_TYPE_NAME_PATTERN, serviceName));
        for (String method : methods) {
            portTypeOperations.add(new PortTypeOperation(method, faultName));
        }
    }

    public List<PortTypeOperation> getPortTypeOperations() {
        return portTypeOperations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PortTypeOperation operation : portTypeOperations) {
            sb.append(operation.getInput()).append("\n");
            sb.append(operation.getOutput()).append("\n");
        }
        sb.append("\n");
        sb.append("    <portType name=\"").append(name).append("\">\n");
        for (PortTypeOperation operation : portTypeOperations) {
            sb.append(operation).append("\n");
        }
        sb.append("    </portType>");
        return sb.toString();
    }
}
