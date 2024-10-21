package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText resultEditText;
    private String input = "";
    private String operator = "";
    private double firstNumber = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultEditText = findViewById(R.id.result);

        // Number button listeners
        findViewById(R.id.button0).setOnClickListener(numberClickListener);
        findViewById(R.id.button1).setOnClickListener(numberClickListener);
        findViewById(R.id.button2).setOnClickListener(numberClickListener);
        findViewById(R.id.button3).setOnClickListener(numberClickListener);
        findViewById(R.id.button4).setOnClickListener(numberClickListener);
        findViewById(R.id.button5).setOnClickListener(numberClickListener);
        findViewById(R.id.button6).setOnClickListener(numberClickListener);
        findViewById(R.id.button7).setOnClickListener(numberClickListener);
        findViewById(R.id.button8).setOnClickListener(numberClickListener);
        findViewById(R.id.button9).setOnClickListener(numberClickListener);

        // Operator button listeners
        findViewById(R.id.buttonAdd).setOnClickListener(operatorClickListener);
        findViewById(R.id.buttonSubtract).setOnClickListener(operatorClickListener);
        findViewById(R.id.buttonMultiply).setOnClickListener(operatorClickListener);
        findViewById(R.id.buttonDivide).setOnClickListener(operatorClickListener);

        // Clear button listener
        findViewById(R.id.buttonClear).setOnClickListener(v -> clear());

        // Equals button listener
        findViewById(R.id.buttonEquals).setOnClickListener(v -> calculate());
    }

    private View.OnClickListener numberClickListener = v -> {
        Button button = (Button) v;
        input += button.getText().toString();
        resultEditText.setText(input);
    };

    private View.OnClickListener operatorClickListener = v -> {
        if (!input.isEmpty()) {
            firstNumber = Double.parseDouble(input);
            Button button = (Button) v;
            operator = button.getText().toString();
            input = "";
        }
    };

    private void clear() {
        input = "";
        firstNumber = 0.0;
        operator = "";
        resultEditText.setText("");
    }

    private void calculate() {
        if (!input.isEmpty()) {
            double secondNumber = Double.parseDouble(input);
            double result = 0.0;

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
                        resultEditText.setText("Error");
                        return;
                    }
                    break;
            }

            resultEditText.setText(String.valueOf(result));
            input = "";
            operator = "";
        }
    }
}
