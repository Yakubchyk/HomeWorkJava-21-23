package com.calculator.storage;


import com.calculator.model.Operation;
import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.util.List;

public interface OperationStorage {
    void save(Operation operation) throws JAXBException;
    public List<Operation> findAll() throws JAXBException, FileNotFoundException;



}
