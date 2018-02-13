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
public class Xsd {

    private final String location;
    private final String namespace;
    private final String prefix;

    public Xsd(String location, String namespace, String prefix) {
        this.location = location;
        this.namespace = namespace;
        this.prefix = prefix;
    }

    public String getLocation() {
        return location;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPrefix() {
        return prefix;
    }

}
