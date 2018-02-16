package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class Element extends NamedObject {

    private ComplexType type;

    public Element(String name) {
        super(name);
        type = new ComplexType(name);
    }

    public ComplexType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "    <xs:element name=\"" + name + "\" type=\"tns:" + type.getName() + "\"/>";
    }
}
