/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.despairs.generator;

/**
 *
 * @author EKovtunenko
 */
public class Pattern {

    public static final String XSD = "<xs:schema version=\"1.0\"\n"
            + "           targetNamespace=\"%s\"\n" //xsd namespace
            + "           xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n"
            + "           xmlns:tns=\"%s\"\n" //xsd namespace
            + "           elementFormDefault=\"qualified\"\n"
            + "           xmlns:jaxb=\"http://java.sun.com/xml/ns/jaxb\" jaxb:version=\"2.1\">\n"
            + "\n"
            + "%s" // ELEMENTS DECALARE
            + "%s" // ELEMENTS DESCRIPTION
            + "\n"
            + "</xs:schema>";

    public static final String XSD_ELEMENTS_DECALRING = "        <xs:element name=\"%s\" type = \"tns:%s\"/>\n"; // method req/resp 
    public static final String XSD_ELEMENTS_DESCRIPTION = "    <xs:element name=\"%s\">\n"// method req/resp 
            + "        <xs:complexType>\n"
            + "            <xs:sequence>\n"
            + "                <xs:element name=\"\" type=\"xs:string\" />\n"
            + "            </xs:sequence>\n"
            + "        </xs:complexType>\n"
            + "    </xs:element>\n";

    public static final String WSDL = "<wsdl:definitions\n"
            + "    name=\"%s\"\n" // serviceName
            + "    targetNamespace=\"%s\"\n" // namespace
            + "    xmlns:tns=\"%s\"\n"// namespace
            + "    xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"\n"
            + "    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"
            + "    xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"\n"
            + "%s" // XSD
            + ">"
            + "\n"
            + "%s" // TYPES
            + "\n"
            + "%s" // MESSAGE
            + "\n"
            + "%s" // PORT
            + "\n"
            + "%s" // BINDING
            + "\n"
            + "%s" // SERVICE
            + "\n"
            + "</wsdl:definitions>";

    public static final String XSD_ANNOTATION = "    xmlns:%s=\"%s\"";
    public static final String TYPES
            = "    <wsdl:types>\n"
            + "        <xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n"
            + "            %s" // TYPES_IMPORT
            + "        </xsd:schema>\n"
            + "    </wsdl:types>\n";
    public static final String TYPES_IMPORT = "<xsd:import "
            + "namespace=\"%s\" " // XSD namespace
            + "schemaLocation=\"%s\"" // XSD location
            + "/>"
            + "\n";
    public static final String MESSAGE
            = "    <wsdl:message name=\"%s\">\n"
            + "        <wsdl:part "
            + "name=\"%s\" " // OBJECTNAME
            + "element=\"%s:%s\"" // PREFIX:OBJECTNAME 
            + "/>\n"
            + "    </wsdl:message>\n";
    public static final String PORT = "    <wsdl:portType name=\"%sPortType\">\n"
            + "%s" // OPERATIONS
            + "    </wsdl:portType>\n";
    public static final String OPERATION = "        <wsdl:operation name=\"%s\">\n"
            + "            <wsdl:input  message=\"tns:%s\"/>\n"
            + "            <wsdl:output message=\"tns:%s\"/>\n"
            + "            <wsdl:fault name=\"SoapFaultException\" message=\"tns:FaultMessage\"/>\n"
            + "        </wsdl:operation>\n";
    public static final String BINDING = "    <wsdl:binding name=\"%sPortBinding\"\n"
            + "                  type=\"tns:%sPortType\">\n"
            + "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\" />\n"
            + "\n"
            + "%s" // BINDING_OPERATION
            + "\n"
            + "    </wsdl:binding>\n";
    public static final String BINDING_OPERATION
            = "        <wsdl:operation name=\"%s\">\n"
            + "            <soap:operation soapAction=\"%s/%s\"/>\n"
            + "            <wsdl:input>\n"
            + "                <soap:body use=\"literal\"/>\n"
            + "            </wsdl:input>\n"
            + "            <wsdl:output>\n"
            + "                <soap:body use=\"literal\"/>\n"
            + "            </wsdl:output>\n"
            + "            <wsdl:fault name=\"SoapFaultException\">\n"
            + "                <soap:fault use=\"literal\" name=\"SoapFaultException\"/>\n"
            + "            </wsdl:fault>\n"
            + "        </wsdl:operation>\n";
    public static final String SERVICE = "    <wsdl:service name=\"%s\">\n"
            + "        <wsdl:port name=\"%sPortType\" binding=\"tns:%sPortBinding\">\n"
            + "            <soap:address location=\"http://localhost/%s/\"/>\n"
            + "        </wsdl:port>\n"
            + "    </wsdl:service>";
}
