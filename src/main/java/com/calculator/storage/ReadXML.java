package com.calculator.storage;

import com.calculator.model.Operation;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;

import java.io.FileReader;

public class ReadXML {

    public void readXML() throws JAXBException, FileNotFoundException {
        JAXBContext context2 = JAXBContext.newInstance(Operation.class);
        Operation unmarshal = (Operation) context2.createUnmarshaller().unmarshal(new FileReader("data.xml"));
        System.out.println(unmarshal);
    }
}
