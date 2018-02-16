package com.despairs.model;

/**
 * @author EKovtunenko
 */
public class RequestMessage extends Message {

    public RequestMessage(String methodName) {
        super(methodName + "Request");
        parts.add(new Part("request", name));
    }
}
