package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class Binding extends NamedObject {

    private static final String BINDING_NAME_PATTERN = "%sPortBinding";
    private static final String OPERATION_PATTERN = "        <operation name=\"%s\">\n" +
            "            <soap:operation soapAction=\"\"/>\n" +
            "            <input>\n" +
            "                <soap:body use=\"literal\"/>\n" +
            "            </input>\n" +
            "            <output>\n" +
            "                <soap:body use=\"literal\"/>\n" +
            "            </output>\n" +
            "            <fault name=\"%s\">\n" +
            "                <soap:fault name=\"%s\" use=\"literal\"/>\n" +
            "            </fault>\n" +
            "        </operation>";

    private PortType portType;

    public Binding(String serviceName, PortType portType) {
        super(String.format(BINDING_NAME_PATTERN, serviceName));
        this.portType = portType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    <binding name=\"").append(name).append("\" type=\"tns:").append(portType.getName()).append("\">\n");
        sb.append("        <soap:binding transport=\"http://schemas.xmlsoap.org/soap/http\" style=\"document\"/>\n");
        for (PortTypeOperation operation : portType.getPortTypeOperations()) {
            String faultName = operation.getFaultName();
            sb.append(String.format(OPERATION_PATTERN, operation.getName(), faultName, faultName)).append("\n");
        }
        sb.append("    </binding>");
        return sb.toString();
    }
}
