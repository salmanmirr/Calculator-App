package com.example.calculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private boolean isNewOperation = true;
    private StringBuilder expression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.displayID);

        findViewById(R.id.zeroID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.oneID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.twoID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.threeID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.fourID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.fiveID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.sixID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.sevenID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.eightID).setOnClickListener(this::onNumberClick);
        findViewById(R.id.nineID).setOnClickListener(this::onNumberClick);

        findViewById(R.id.addID).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.subtractID).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.multiplyID).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.divideID).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.percentageID).setOnClickListener(this::onOperatorClick);
        // findViewById(R.id.sinID).setOnClickListener(this:: onSinClick);
        // findViewById(R.id.cosID).setOnClickListener(this:: onCosClick);

        findViewById(R.id.equalID).setOnClickListener(this::onEqualsClick);

        findViewById(R.id.acID).setOnClickListener(view -> clear());

        findViewById(R.id.deleteID).setOnClickListener(view -> deleteLastCharacter());
    }


    private void onNumberClick(View view) {
        Button button = (Button) view;
        if (isNewOperation) {
            expression.setLength(0);
            isNewOperation = false;
        }
        expression.append(button.getText().toString());
        displayTextView.setText(expression.toString());
    }

    private void onOperatorClick(View view) {
        Button button = (Button) view;

        if (!isNewOperation) {
            expression.append(button.getText().toString());
            displayTextView.setText(expression.toString());
            isNewOperation = false;
        }
    }

    private void onEqualsClick(View view) {

        try {
            double result = evaluateExpression(expression.toString());

            if (result == (int) result) {
                displayTextView.setText(String.valueOf((int) result));
            } else {
                displayTextView.setText(String.valueOf(result));
            }

        } catch (Exception e) {
            displayTextView.setText("Error");
        }
        isNewOperation = true;
    }

    private double evaluateExpression(String expr) {
        double result = 0;
        char lastOperator = '+';
        StringBuilder numberBuilder = new StringBuilder();

        for (char ch : expr.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                numberBuilder.append(ch);
            } else {
                result = calculate(result, Double.parseDouble(numberBuilder.toString()), lastOperator);
                lastOperator = ch;
                numberBuilder.setLength(0);
            }
        }

        if (numberBuilder.length() > 0) {
            result = calculate(result, Double.parseDouble(numberBuilder.toString()), lastOperator);
        }
        return result;
    }

    private double calculate(double left, double right, char operator) {
        switch(operator) {
            case '+': return left + right;
            case '-': return left - right;
            case '*': return left * right;
            case '/':
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;
            case '%':
                return left * (right / 100);
            default: return 0;
        }
    }

    private void deleteLastCharacter() {
        if (expression.length() > 0) {
            expression.deleteCharAt(expression.length() -1);
            displayTextView.setText(expression.toString());
            if (expression.length() == 0) {
                displayTextView.setText("0");
            }
        }
    }


    private void clear() {
        expression.setLength(0);
        displayTextView.setText("0");
        isNewOperation = true;
    }
}