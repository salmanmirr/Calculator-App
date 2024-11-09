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
}
