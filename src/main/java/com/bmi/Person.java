package com.bmi;

import com.bmi.contracts.InnerPerson;

import javafx.beans.property.*;

public class Person implements InnerPerson {
    private final DoubleProperty weight = new SimpleDoubleProperty();
    private final DoubleProperty height = new SimpleDoubleProperty();

    public Person(double weight, double height) {
        setWeight(weight);
        setHeight(height);
    }

    public double getWeight() {
        return weight.get();
    }

    public double getHeight() {
        return height.get();
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public double calculateBMI() {
        if (getHeight() <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return getWeight() / (getHeight() * getHeight());
    }

    public String checkBMIStatus() {
        double bmi = this.calculateBMI();
        
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
