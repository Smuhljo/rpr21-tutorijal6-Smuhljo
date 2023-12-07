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
        display.setText(display.getText() + value);
    }

    @FXML
    private void onOperatorClicked(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            display.setText(display.getText() + value);
        } else {
            display.setText(evaluateExpression(display.getText()));
        }
    }

    private String evaluateExpression(String expression) {
        if (expression.contains("/0")) {
            return "Gdje ces sa 0 dijelit";
        }
        try {
            expression = expression.replaceAll("x", "*"); // Replace 'x' with '*' for multiplication
            Object result = engine.eval(expression);
            return result.toString();
        } catch (ScriptException e) {
            return "Error";
        }
    }
}
