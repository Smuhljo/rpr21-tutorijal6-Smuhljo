package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Controller {

    @FXML
    private TextField display;

    private final ScriptEngine engine;

    public Controller() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("JavaScript");
    }

    @FXML
    private void onNumberClicked(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        display.setText(display.getText() + value);
    }

    @FXML
    private void clearDisplay() {
        display.setText("");
    }

    @FXML
    private void onBracketClicked(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        String currentDisplay = display.getText();

        if (value.equals("(")) {
            // Allow '(' if display is empty or ends with an operator or another '('
            if (currentDisplay.isEmpty() || isOperator(currentDisplay.charAt(currentDisplay.length() - 1)) || currentDisplay.endsWith("(")) {
                display.setText(currentDisplay + value);
            }
        } else if (value.equals(")")) {
            // Allow ')' if there are unmatched '(' and display does not end with an operator
            if (hasUnmatchedOpeningBracket(currentDisplay) && !isOperator(currentDisplay.charAt(currentDisplay.length() - 1))) {
                display.setText(currentDisplay + value);
            }
        }
    }

    @FXML
    private void onOperatorClicked(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        String currentDisplay = display.getText();

        if (!"=".equals(value)) {
            // Prevent adding an operator if display is empty or ends with an operator
            if (currentDisplay.isEmpty() || isOperator(currentDisplay.charAt(currentDisplay.length() - 1))) {
                return;
            }
            display.setText(currentDisplay + value);
        } else {
            display.setText(evaluateExpression(currentDisplay));
        }
    }

    private String evaluateExpression(String expression) {
        if (expression.contains("/0")) {
            return "Gdje ces sa 0 dijelit";
        }
        try {
            expression = expression.replaceAll("x", "*");
            Object result = engine.eval(expression);
            return result.toString();
        } catch (ScriptException e) {
            return "Error";
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == '/';
    }

    private boolean hasUnmatchedOpeningBracket(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
        }
        return count > 0; // true if there are unmatched '('
    }
}
