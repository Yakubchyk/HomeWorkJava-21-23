package com.calculator;

import com.calculator.model.Operation;
import com.calculator.web.CalculatorServer;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        CalculatorServer calculatorServer = new CalculatorServer();
        try {
            calculatorServer.startServer();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}




//        ConsoleApplication consoleApplication = new ConsoleApplication();
//        consoleApplication.run();
//
//        CalculatorServer server = new CalculatorServer();
//        try {
//            server.startServer(consoleApplication.getOperation());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        Operation operation = new Operation();
//        operation.setNum1(2);
//        operation.setNum2(2);
//        operation.setResult(4);
//        operation.setOperator("sum");
//
//        JAXBContext context = JAXBContext.newInstance(Operation.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(operation, new File("data.xml"));

//        JAXBContext context2 = JAXBContext.newInstance(Operation.class);
//        Operation unmarshal = (Operation) context2.createUnmarshaller().unmarshal(new FileReader("data.xml"));
//        System.out.println(unmarshal);