package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class BindingOperation extends NamedObject {
    private String soapAction;
    private Message fault;

    public BindingOperation(String name) {
        super(name);
    }
}
