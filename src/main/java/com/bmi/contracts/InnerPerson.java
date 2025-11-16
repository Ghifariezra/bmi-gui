package com.bmi.contracts;

import javafx.beans.property.*;

public interface InnerPerson {
    // Getter
    double getWeight();
    double getHeight();

    // Setter
    void setWeight(double weight);
    void setHeight(double height);

    // Property
    DoubleProperty weightProperty();
    DoubleProperty heightProperty();

    // Calculate BMI
    double calculateBMI();
    String checkBMIStatus();
}