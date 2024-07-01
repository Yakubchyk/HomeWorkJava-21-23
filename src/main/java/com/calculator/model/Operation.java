package com.calculator.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "operations")
@XmlType(propOrder = {"num1", "num2", "operator", "result"})
public class Operation {
    private double num1;
    private double num2;
    private String operator;
    private double result;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", operator='" + operator + '\'' +
                '}';
    }
}
