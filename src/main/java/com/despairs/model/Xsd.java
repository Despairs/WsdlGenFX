package com.despairs.model;

/**
 * @author EKovtunenko
 */
public class Xsd {

    private final Wsdl wsdl;

    public Xsd(Wsdl wsdl) {
        this.wsdl = wsdl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        String xsdNamespace = wsdl.getXsdNamespace();
        sb.append("<xs:schema version=\"1.0\" targetNamespace=\"").append(xsdNamespace).append("\"").append("\n")
                .append("           xmlns:tns=\"").append(xsdNamespace).append("\"").append("\n")
                .append("           xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n" +
                        "           elementFormDefault=\"qualified\"\n" +
                        "           xmlns:jaxb=\"http://java.sun.com/xml/ns/jaxb\"\n" +
                        "           jaxb:version=\"2.1\">\n\n");
        PortType portType = wsdl.getPortType();
        for (PortTypeOperation operation : portType.getPortTypeOperations()) {
            sb.append(operation.getInput().parts.get(0).getElement()).append("\n");
            sb.append(operation.getOutput().parts.get(0).getElement()).append("\n");
        }

        sb.append(wsdl.getFaultMessage().parts.get(0).getElement()).append("\n");
        sb.append("\n");
        sb.append(wsdl.getFaultMessage().parts.get(0).getElement().getType()).append("\n");

        for (PortTypeOperation operation : portType.getPortTypeOperations()) {
            sb.append(operation.getInput().parts.get(0).getElement().getType()).append("\n");
            sb.append(operation.getOutput().parts.get(0).getElement().getType()).append("\n");
            sb.append("\n");
        }


        sb.append("</xs:schema>");
        return sb.toString();
    }
}
