package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField display;

    private double data = 0.0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void onNumberClicked(javafx.event.ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        display.setText(display.getText() + value);
    }

    @FXML
    private void onOperatorClicked(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;
            operator = value;
            data = Double.parseDouble(display.getText());
            display.setText("");
        } else {
            if (operator.isEmpty()) return;
            display.setText(String.format("%.2f", calculate(data, Double.parseDouble(display.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    private double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "x":
                return a * b;
            case "/":
                if (b == 0) return 0;
                return a / b;
            case "%":
                return a % b;
        }
        return 0;
    }
}
