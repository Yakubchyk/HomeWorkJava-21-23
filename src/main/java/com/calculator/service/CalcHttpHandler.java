package com.calculator.service;

import com.calculator.model.Operation;
import com.calculator.storage.XMLFileOperationStorage;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


public class CalcHttpHandler implements HttpHandler {
    private final Operation operation;

    public CalcHttpHandler(Operation operation) {
        this.operation = operation;
    }

    XMLFileOperationStorage xmlFileOperationStorage = new XMLFileOperationStorage();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getQuery();
        Map<String, String> parameters = parseQuery(query);
        OperationService operationService = new OperationService();

        Operation operation = new Operation();
        operation.setNum1(Double.parseDouble(parameters.get("num1")));
        operation.setNum2(Double.parseDouble(parameters.get("num2")));
        operation.setOperator(parameters.get("type"));


        Operation result = operationService.getResult(operation);

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



        String response = "<html><head><title>Calculator Result</title></head>" +
                "<body>" +
                "<h1>Calculator Result</h1>" +
                "<p>Numb1 : " + operation.getNum1() + "</p>" +
                "<p>Num2 : " + operation.getNum2() + "</p>" +
                "<p>Operator : " + operation.getOperator() + "</p>" +
                "<p>Result : " + operation.getResult() + "</p>" +
                "</body></html>";
        exchange.getResponseHeaders().add("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();

        os.write(response.getBytes());
        os.close();
    }

    private Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            String[] split = pair.split("=");
            result.put(split[0], split[1]);
        }
        return result;

    }
}
