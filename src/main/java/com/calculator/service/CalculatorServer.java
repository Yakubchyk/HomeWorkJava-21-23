package com.calculator.service;

import com.calculator.model.Operation;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class CalculatorServer {

    private HttpServer httpServer;

    public void startServer(Operation operation) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/calc", new CalcHttpHandler(operation));
        httpServer.start();
    }

//        public void stopServer() {
//            if (httpServer != null) {
//                httpServer.stop(0);
//            }
//        }

}


