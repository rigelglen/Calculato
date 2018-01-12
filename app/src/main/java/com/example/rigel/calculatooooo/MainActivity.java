package com.example.rigel.calculatooooo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    String expression = "";
    boolean operationCompleted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btn0 = findViewById(R.id.button0);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);

        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button leftParen = findViewById(R.id.leftParen);
        Button rightParen = findViewById(R.id.rightParen);
        Button inverse = findViewById(R.id.inverse);
        Button sqrt = findViewById(R.id.sqrt);

        Button clear = findViewById(R.id.clear);
        Button point = findViewById(R.id.point);
        Button equal = findViewById(R.id.equals);
        Button back = findViewById(R.id.back);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        leftParen.setOnClickListener(this);
        rightParen.setOnClickListener(this);
        inverse.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        back.setOnClickListener(this);

        EditText tw = findViewById(R.id.result);

        tw.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });

        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearText();
                return false;
            }
        });

    }

    public static String appendAt(String exp, int pos, String c) {
        return exp.substring(0, pos).concat(c).concat(exp.substring(pos, exp.length()));
    }

    public void delSqrt() {
        EditText result = this.findViewById(R.id.result);
        int tempPos = result.getSelectionStart();
        expression = expression.substring(0, tempPos - 5).concat(expression.substring(tempPos, expression.length()));
        result.setText(expression, TextView.BufferType.EDITABLE);
        result.setSelection(tempPos - 5);
        return;
    }

    public void clearText() {
        EditText result = this.findViewById(R.id.result);
        expression = "";
        result.setText(expression, TextView.BufferType.EDITABLE);
        result.setSelection(0);
        operationCompleted = false;
    }

    @Override
    public void onClick(View v) {
        EditText result = findViewById(R.id.result);
        int storedPosition;
        switch (v.getId()) {
            case R.id.button0:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "0");
                break;
            case R.id.button1:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "1");
                break;
            case R.id.button2:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "2");
                break;
            case R.id.button3:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "3");
                break;
            case R.id.button4:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "4");
                break;
            case R.id.button5:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "5");
                break;
            case R.id.button6:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "6");
                break;
            case R.id.button7:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "7");
                break;
            case R.id.button8:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "8");
                break;
            case R.id.button9:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "9");
                break;
            case R.id.plus:
                operationCompleted = false;
                expression = appendAt(expression, result.getSelectionStart(), "+");
                break;
            case R.id.minus:
                operationCompleted = false;
                expression = appendAt(expression, result.getSelectionStart(), "-");
                break;
            case R.id.multiply:
                operationCompleted = false;
                expression = appendAt(expression, result.getSelectionStart(), "*");
                break;
            case R.id.divide:
                operationCompleted = false;
                expression = appendAt(expression, result.getSelectionStart(), "/");
                break;
            case R.id.point:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), ".");
                break;
            case R.id.leftParen:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "(");
                break;
            case R.id.rightParen:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), ")");
                break;
            case R.id.clear:
                clearText();
                return;
            case R.id.inverse:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "^");
                break;
            case R.id.sqrt:
                if (operationCompleted == true) {
                    clearText();
                }
                expression = appendAt(expression, result.getSelectionStart(), "sqrt(");
                storedPosition = result.getSelectionStart();
                result.setText(expression, TextView.BufferType.EDITABLE);
                result.setSelection(storedPosition + 5);
                return;

            case R.id.back:
            {
                operationCompleted = false;
                if (expression == "" || result.getSelectionStart() == 0)
                    return;
                if (expression.length() == 1) {
                    expression = "";
                    result.setText(expression, TextView.BufferType.EDITABLE);
                    result.setSelection(0);
                    return;
                }
                char prevChar = result.getText().toString().charAt(result.getSelectionStart() - 1);
                if (prevChar == '(') {
                    if (result.getText().toString().charAt(result.getSelectionStart() - 2) == 't') {
                        delSqrt();
                        return;
                    }
                } else if (prevChar == 's' || prevChar == 'q' || prevChar == 'r' || prevChar == 't') {
                    String text = result.getText().toString();

                    int posParen = text.indexOf('(', result.getSelectionStart() - 1) + 1;
                    result.setSelection(posParen);
                    delSqrt();
                    return;
                }
                if (result.getSelectionStart() == expression.length()) {
                    expression = expression.substring(0, expression.length() - 1);
                    result.setText(expression, TextView.BufferType.EDITABLE);
                    result.setSelection(expression.length());
                } else {
                    int tempPos = result.getSelectionStart();
                    if (tempPos == 0)
                        return;
                    else {
                        expression = expression.substring(0, tempPos - 1).concat(expression.substring(tempPos, expression.length()));
                        result.setText(expression, TextView.BufferType.EDITABLE);
                        result.setSelection(tempPos - 1);
                    }
                }

                return;

            }

            case R.id.equals:
                operationCompleted = false;
                try {
                    MathEval m = new MathEval();
                    double value = m.evaluate(expression);
                    value = (double)Math.round(value * 100000000000d) / 100000000000d;
                    expression = String.valueOf(value);
                    operationCompleted = true;
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Invalid operation", Toast.LENGTH_SHORT).show();
                }
                result.setText(expression, TextView.BufferType.EDITABLE);
                result.setSelection(result.getText().length());
                return;
            default:

        }
        storedPosition = result.getSelectionStart();
        result.setText(expression, TextView.BufferType.EDITABLE);
        result.setSelection(storedPosition + 1);
    }
}