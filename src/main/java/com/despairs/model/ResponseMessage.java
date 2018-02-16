package com.despairs.model;

/**
 * @author EKovtunenko
 */
public class ResponseMessage extends Message {

    public ResponseMessage(String methodName) {
        super(methodName + "Response");
        parts.add(new Part("response", name));
    }
}
