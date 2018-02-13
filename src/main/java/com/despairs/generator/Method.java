/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.despairs.generator;

/**
 * @author EKovtunenko
 */
public class Method {

    private final String request;
    private final String response;
    private final String name;

    public Method(String name) {
        this.name = name;
        String uppedMethodName = StringUtils.upFirstSymbol(name);
        request = uppedMethodName + "Request";
        response = uppedMethodName + "Response";
    }

    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public String getName() {
        return name;
    }

}
