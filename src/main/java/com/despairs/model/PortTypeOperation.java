package com.despairs.model;

import com.despairs.utils.StringUtils;
import com.despairs.model.base.NamedObject;

/**
 * @author EKovtunenko
 */
public class PortTypeOperation extends NamedObject {

    private Message input;
    private Message output;
    private String faultName;

    public PortTypeOperation(String name, String faultName) {
        super(StringUtils.upFirstSymbol(name));
        this.faultName = faultName;
        createMessages();
    }

    private void createMessages() {
        input = new RequestMessage(name);
        output = new ResponseMessage(name);
    }

    public String getFaultName() {
        return faultName;
    }

    public Message getInput() {
        return input;
    }

    public Message getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "         <operation name=\"" + name + "\">\n" +
                "            <input message=\"tns:" + input.getName() + "\"/>\n" +
                "            <output message=\"tns:" + output.getName() + "\"/>\n" +
                "            <fault message=\"tns:" + faultName + "\" name=\"" + faultName + "\"/>\n" +
                "        </operation>   ";
    }
}
