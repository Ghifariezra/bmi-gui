# BMI Calculator - JavaFX GUI Application

<div style="text-align: center;">
    <img src="public/bmi-ui.png" alt="BMI Calculator Application Screenshot" width="300">
</div>

## Description

A simple JavaFX-based BMI Calculator application to calculate the Body Mass Index (BMI) based on the user's weight and height. The application displays the BMI result along with the weight category status (Underweight, Normal weight, Overweight, Obesity) with a responsive and user-friendly GUI.

---

## Project Structure

```bash
com.bmi
├── Main.java           # Application entry point, setup stage and scene
├── BMICalculatorView.java # UI layout and BMI input/output logic
├── Person.java         # Person data model with BMI calculation logic
└── contracts
    └── InnerPerson.java # Interface contract for the Person class

com.bmi.utils
├── IconLoader.java     # Utility to load application icons
└── RootBackground.java # Utility to set background for root layout
```

---

## How to Run the Application

-   Make sure Java and JavaFX SDK are installed on your system.
-   Open the bmi-calculator folder in the terminal.
-   Run the command mvn clean package to compile the project.
-   Run the command mvn javafx:run@bmi to launch the application.

---

## How to Use

-   Enter your weight in kilograms in the "Weight (kg)" field.
-   Enter your height in meters in the "Height (m)" field.
    > If the value entered is greater than 10 (e.g., 170), the app will automatically convert it to meters (1.70).
-   Click the Calculate BMI button.
-   The BMI result and weight category will appear below.
    If the input is invalid, an error dialog will be shown.

---

## BMI Calculation Logic

BMI formula:

> BMI = weight (kg) / (height (m) × height (m))

BMI Categories:

-   `Underweight`: BMI < 18.5
-   `Normal weight`: 18.5 ≤ BMI < 24.9
-   `Overweight`: 25 ≤ BMI < 29.9
-   `Obesity`: BMI ≥ 30

---

## Explanation of Main Classes

### `Main.java`

-   Starts the JavaFX application.
-   Sets up the scene and stage.
-   Uses BMICalculatorView as the root UI.

### `BMICalculatorView.java`

-   Manages the UI using a VBox.
-   Contains labels, input fields, calculate button, and result label.
-   Handles button click events, input validation, and displays BMI and category.
-   Provides color feedback based on BMI status.

### `Person.java`

-   Data model with weight and height properties.
-   Implements BMI calculation and weight status determination logic.

### `IconLoader.java`

-   Loads application icon from resources.

### `RootBackground.java`

-   Provides a white background for the root layout.

### `InnerPerson.java`

-   Interface defining the contract for the Person class.

---

## Application Deployment

1. Make sure JavaFX SDK & JMods are installed on your system.
    
    If not, you can download them from:
    - [JavaFX SDK & JMods (Gluon)](https://gluonhq.com/products/javafx/)

2. Create a folder named launch-app.

3. Run this command to create a custom JavaFX runtime image:
    ```bash
    jlink --module-path "D:\Program Files\JavaFx\JavaFx-21-JMods;D:\Program Files\JavaFx\JavaFx-21-SDK\lib" \
        --add-modules java.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.web,javafx.media,javafx.swing \
        --output runtime
    ```
4. Run this command to create the executable application:
    ```bash
    jpackage --input target \
            --name Bmi-Calculator \
            --main-jar bmi-calculator-1.0.jar \
            --main-class com.bmi.Main \
            --type exe \
            --icon .\src\main\resources\icon\bmi.ico \
            --runtime-image runtime \
            --win-shortcut \
            --win-menu \
            --dest .\launch-app\
    ```
