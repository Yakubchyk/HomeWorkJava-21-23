package com.calculator.web;

import com.calculator.model.Operation;
import com.calculator.service.CalcHttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class CalculatorServer {


    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        Operation operation = new Operation();
        httpServer.createContext("/calc", new CalcHttpHandler(operation));
        httpServer.start();
    }
}


