package com.despairs.model;

import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class ComplexType extends NamedObject {

    public ComplexType(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "    <xs:complexType name=\"" + name + "\">\n" +
                "        <xs:sequence>\n" +
                "            <xs:element name=\"val\" type=\"xs:string\" minOccurs=\"0\"/>\n" +
                "        </xs:sequence>\n" +
                "    </xs:complexType>";
    }
}
