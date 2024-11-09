package com.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isNewOperation = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
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

        findViewById(R.id.equalID).setOnClickListener(this::onEqualsClick);

        findViewById(R.id.acID).setOnClickListener(view -> clear());


    }

    private void onNumberClick(View view) {
        Button button = (Button) view;
        String currentText = displayTextView.getText().toString();

        if (isNewOperation) {
            displayTextView.setText(button.getText().toString());
            isNewOperation = false;

        } else {
            displayTextView.setText(currentText + button.getText().toString());
        }
    }

    private void onOperatorClick(View view) {
        Button button = (Button) view;
        firstNumber = Double.parseDouble(displayTextView.getText().toString());
        operator = button.getText().toString();
        isNewOperation = true;
    }

    private void onEqualsClick(View view) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    displayTextView.setText("Error");
                    operator = "";
                    isNewOperation = true;
                    return;
                }
                break;


        }
        displayTextView.setText(String.valueOf(result));
        operator = "";
        isNewOperation = true;
    }

    private void clear() {
        displayTextView.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
        isNewOperation = true;
    }

}
