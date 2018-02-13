/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.despairs.generator;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EKovtunenko
 */
public class Generator {

    private String namespace;
    private String serviceName;
    private Xsd xsd = new Xsd("default", "default", "xs");
    private final List<Method> methods = new ArrayList<>();

    public void generateWsdl(PrintStream os) {
        String wsdl = String.format(Pattern.WSDL,
                serviceName,
                namespace,
                namespace,
                generateXsdAnnotation(),
                generateTypes(),
                generateMessages(),
                generatePort(),
                generateBinding(),
                generateService());
        os.println(wsdl);
    }

    public void generateXsd(PrintStream os) {
        String _xsd = String.format(Pattern.XSD,
                xsd.getNamespace(),
                xsd.getNamespace(),
                generateElementsDeclaring(),
                generateElementsDescription());
        os.println(_xsd);
    }

    private String generateElementsDeclaring() {
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(String.format(Pattern.XSD_ELEMENTS_DECALRING, method.getRequest(), method.getRequest()));
            sb.append(String.format(Pattern.XSD_ELEMENTS_DECALRING, method.getResponse(), method.getResponse()));
        }
        return sb.toString();
    }

    private String generateElementsDescription() {
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(String.format(Pattern.XSD_ELEMENTS_DESCRIPTION, method.getRequest()));
            sb.append(String.format(Pattern.XSD_ELEMENTS_DESCRIPTION, method.getResponse()));
        }
        return sb.toString();
    }

    private String generateXsdAnnotation() {
        return String.format(Pattern.XSD_ANNOTATION, xsd.getPrefix(), xsd.getNamespace());
    }

    private String generateService() {
        return String.format(Pattern.SERVICE, serviceName, serviceName, serviceName, serviceName);
    }

    private String generateBinding() {
        return String.format(Pattern.BINDING, serviceName, serviceName, generateBindingOperations());
    }

    private String generateBindingOperations() {
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(String.format(Pattern.BINDING_OPERATION, method.getName(), namespace, method.getName()));
        }
        return sb.toString();
    }

    private String generatePort() {
        return String.format(Pattern.PORT, serviceName, generatePortOperations());
    }

    private String generatePortOperations() {
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(String.format(Pattern.OPERATION, method.getName(), method.getRequest(), method.getResponse()));
        }
        return sb.toString();
    }

    private String generateTypes() {
        return String.format(Pattern.TYPES, generateTypesImport());
    }

    private String generateTypesImport() {
        return String.format(Pattern.TYPES_IMPORT, xsd.getNamespace(), xsd.getLocation());
    }

    private String generateMessages() {
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(generateRequestMessage(method));
            sb.append(generateResponseMessage(method));
        }
        return sb.toString();
    }

    private String generateRequestMessage(Method method) {
        return generateMessage(method.getRequest(), "request");
    }

    private String generateResponseMessage(Method method) {
        return generateMessage(method.getResponse(), "response");
    }

    private String generateMessage(String name, String type) {
        return String.format(Pattern.MESSAGE, name, type, xsd.getPrefix(), name);
    }

    public String getServiceName() {
        return serviceName;
    }

    public static Builder newBuilder() {
        return new Generator().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder withServiceName(String serviceName) {
            Generator.this.serviceName = serviceName;
            return this;
        }

        public Builder withNamespace(String namespace) {
            Generator.this.namespace = namespace;
            return this;
        }

        public Builder withXsd(String fileName, String namespace) {
            Generator.this.xsd = new Xsd(fileName, namespace, "xs");
            return this;
        }

        public Builder withMethod(String name) {
            Generator.this.methods.add(new Method(name));
            return this;
        }

        public Builder withMethods(List<String> names) {
            for (String name : names) {
                Generator.this.methods.add(new Method(name));
            }
            return this;
        }

        public Builder withMethods(String... names) {
            for (String name : names) {
                Generator.this.methods.add(new Method(name));
            }
            return this;
        }

        public Generator build() {
            return Generator.this;
        }

    }
}
