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
