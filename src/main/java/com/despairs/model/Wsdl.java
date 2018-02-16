package com.despairs.model;

/**
 * @author EKovtunenko
 */
public class Wsdl {

    private static final String NAMESPACE_PATTERN = "http://%s";

    private final String serviceName;
    private final String namespace;
    private final String xsdNamespace;
    private final Message faultMessage;

    private PortType portType;
    private Binding binding;
    private Service service;

    public Wsdl(String serviceName, String namespace, String xsdNamespace, String faultName) {
        this.serviceName = serviceName;
        this.namespace = String.format(NAMESPACE_PATTERN, namespace);
        this.xsdNamespace = xsdNamespace != null && !xsdNamespace.isEmpty() ? String.format(NAMESPACE_PATTERN, xsdNamespace) : this.namespace;
        faultMessage = new FaultMessage(faultName);
    }

    public void setMethods(String... methods) {
        portType = new PortType(serviceName, faultMessage.getName(), methods);
        binding = new Binding(serviceName, portType);
        service = new Service(serviceName, binding);
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getXsdNamespace() {
        return xsdNamespace;
    }

    public Message getFaultMessage() {
        return faultMessage;
    }

    public PortType getPortType() {
        return portType;
    }

    @Override
    public String toString() {
        String ret = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<definitions\n"
                + "    name=\"" + service.getName() + "\"\n"
                + "    targetNamespace=\"" + namespace + "\"\n"
                + "    xmlns=\"http://schemas.xmlsoap.org/wsdl/\""
                + "    xmlns:tns=\"" + namespace + "\"\n"
                + "    xmlns:xs=\"" + xsdNamespace + "\"\n"
                + "    xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"\n"
                + "    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"
                + "    xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\">\n\n"
                + "    <types>\n"
                + "        <xsd:schema>\n"
                + "            <xsd:import namespace=\"" + xsdNamespace + "\" schemaLocation=\"" + service.getName() + ".xsd\"/>\n"
                + "        </xsd:schema>\n"
                + "    </types>\n\n"
                + faultMessage + "\n"
                + portType + "\n"
                + binding + "\n"
                + service + "\n"
                + "</definitions>";
        if (!xsdNamespace.equals(namespace)) {
            ret = ret.replace("element=\"tns", "element=\"xs");
        }
        return ret;
    }
}
