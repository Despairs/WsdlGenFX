package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class Part extends NamedObject {

    private Element element;

    public Part(String name, String messageName) {
        super(name);
        element = new Element(messageName);
    }

    public Element getElement() {
        return element;
    }

    @Override
    public String toString() {
        return "        <part name=\"" + name + "\" element=\"tns:" + element.getName() + "\"/>";
    }
}
