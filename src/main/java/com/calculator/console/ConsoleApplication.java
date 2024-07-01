package com.calculator.console;

import com.calculator.model.Operation;
import com.calculator.service.OperationService;
import com.calculator.storage.ReadXML;
import com.calculator.storage.WriteXML;
import jakarta.xml.bind.JAXBException;

public class ConsoleApplication implements Application {
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final OperationService operationService = new OperationService();
    private final WriteXML writeXML = new WriteXML();
    private final ReadXML readXML = new ReadXML();
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
            writeXML.writeXML(operation);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        try {
            readXML.readXML();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Operation getOperation() {
        return operation;
    }
}
