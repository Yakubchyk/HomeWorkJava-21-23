package com.calculator.storage;

import com.calculator.model.Operation;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.nio.file.Path;

public class WriteXML {

    String file = "data.xml";


    public void writeXML(Operation operation) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Operation.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(operation, new File(file));
    }
}
