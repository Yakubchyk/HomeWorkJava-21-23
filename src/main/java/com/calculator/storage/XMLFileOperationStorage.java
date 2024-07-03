package com.calculator.storage;

import com.calculator.model.Operation;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class XMLFileOperationStorage implements OperationStorage {

    String file = "data.xml";

    @Override
    public void save(Operation operation) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Operation.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(operation, new File(file));

    }

    @Override
    public List<Operation> findAll() throws JAXBException, FileNotFoundException {
        JAXBContext context2 = JAXBContext.newInstance(Operation.class);
        Operation unmarshal = (Operation) context2.createUnmarshaller().unmarshal(new FileReader(file));
        System.out.println(unmarshal);
        return List.of();
    }
}



