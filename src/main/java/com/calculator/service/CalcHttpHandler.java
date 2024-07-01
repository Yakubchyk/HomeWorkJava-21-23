package com.calculator.service;

import com.calculator.model.Operation;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CalcHttpHandler implements HttpHandler {
    private final Operation operation;

    public CalcHttpHandler(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();

        String response = "<html><head><title>Calculator Result</title></head>" +
                "<body>" +
                "<h1>Calculator Result</h1>" +
                "<p>Numb1 : " + operation.getNum1() + "</p>" +
                "<p>Num2 : " + operation.getNum2() + "</p>" +
                "<p>Operator : " + operation.getOperator() + "</p>" +
                "<p>Result : " + operation.getResult() + "</p>" +
                "</body></html>";

        os.write(response.getBytes());
        os.close();
    }
}
