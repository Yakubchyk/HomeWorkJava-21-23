package com.calculator.console;

import com.calculator.model.Operation;
import com.calculator.service.OperationService;
import com.calculator.storage.XMLFileOperationStorage;
import jakarta.xml.bind.JAXBException;

public class ConsoleApplication implements Application {
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final OperationService operationService = new OperationService();
    XMLFileOperationStorage xmlFileOperationStorage = new XMLFileOperationStorage();

    private final Operation operation = new Operation();

    public void run() {
        consoleWriter.write("Enter num 1: ");
        operation.setNum1(consoleReader.readNumber());
        consoleWriter.write("Enter num 2: ");
        operation.setNum2(consoleReader.readNumber());
        consoleWriter.write("Enter operation type: sum, sub, mul, div: ");
        operation.setOperator(consoleReader.readOperation());

        operationService.getResult(operation);

        consoleWriter.write("Result : " + operation.getResult());

        try {
            xmlFileOperationStorage.save(operation);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        try {
            xmlFileOperationStorage.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Operation getOperation() {
        return operation;
    }
}
