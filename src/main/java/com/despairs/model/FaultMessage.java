package com.despairs.model;

/**
 * @author EKovtunenko
 */
public class FaultMessage extends Message {

    public FaultMessage(String name) {
        super(name);
        parts.add(new Part("fault", name));
    }
}
