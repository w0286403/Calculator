package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Calculations calculation = new Calculations();

    Button btn_clear, btn_delete, btn_divide, btn_multiply, btn_add, btn_posAndNeg, btn_subtract, btn_decimal,
            btn_evaluate, btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven,
            btn_eight, btn_nine;

    EditText et_displayTotal;

    double leftNum, rightNum;
    char operator;
    boolean hasOperator = false;
    StringBuilder numString = new StringBuilder("");
    boolean isNewCalculation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_displayTotal = findViewById(R.id.et_displayTotal);

        btn_clear = findViewById(R.id.btn_clear);
        btn_delete = findViewById(R.id.btn_delete);
        btn_posAndNeg = findViewById(R.id.btn_posAndNeg);
        btn_divide = findViewById(R.id.btn_divide);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_subtract = findViewById(R.id.btn_subtract);
        btn_add = findViewById(R.id.btn_add);
        btn_decimal = findViewById(R.id.btn_decimal);
        btn_evaluate = findViewById(R.id.btn_evaluate);

        btn_zero = findViewById(R.id.btn_zero);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);

        btn_zero.setOnClickListener(onNumberClicked);
        btn_one.setOnClickListener(onNumberClicked);
        btn_two.setOnClickListener(onNumberClicked);
        btn_three.setOnClickListener(onNumberClicked);
        btn_four.setOnClickListener(onNumberClicked);
        btn_five.setOnClickListener(onNumberClicked);
        btn_six.setOnClickListener(onNumberClicked);
        btn_seven.setOnClickListener(onNumberClicked);
        btn_eight.setOnClickListener(onNumberClicked);
        btn_nine.setOnClickListener(onNumberClicked);

        btn_clear.setOnClickListener(onButtonClicked);
        btn_delete.setOnClickListener(onButtonClicked);
        btn_evaluate.setOnClickListener(onButtonClicked);
        btn_posAndNeg.setOnClickListener(onNumberClicked);
        btn_decimal.setOnClickListener(onNumberClicked);

        btn_divide.setOnClickListener(onOperatorClicked);
        btn_multiply.setOnClickListener(onOperatorClicked);
        btn_subtract.setOnClickListener(onOperatorClicked);
        btn_add.setOnClickListener(onOperatorClicked);

    }//end OnCreate

    public View.OnClickListener onNumberClicked = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if (isNewCalculation){
                et_displayTotal.setText("");
            }
            isNewCalculation = false;
            switch (view.getId()){
                case (R.id.btn_zero):
                    numString.append("0");
                    break;
                case (R.id.btn_one):
                    numString.append("1");
                    break;
                case (R.id.btn_two):
                    numString.append("2");
                    break;
                case (R.id.btn_three):
                    numString.append("3");
                    break;
                case (R.id.btn_four):
                    numString.append("4");
                    break;
                case (R.id.btn_five):
                    numString.append("5");
                    break;
                case (R.id.btn_six):
                    numString.append("6");
                    break;
                case (R.id.btn_seven):
                    numString.append("7");
                    break;
                case (R.id.btn_eight):
                    numString.append("8");
                    break;
                case (R.id.btn_nine):
                    numString.append("9");
                    break;
                case (R.id.btn_decimal):
                    if (!numString.toString().contains(".")){
                        numString.append(".");
                    }
                    break;
                case (R.id.btn_posAndNeg):
                    if (!numString.toString().contains("-")){
                        numString.insert(0,"-");
                    }else{
                        numString.deleteCharAt(0);
                    }
                    break;
                default:
                    break;
            }
            et_displayTotal.setText(numString);
        }
    };

    public View.OnClickListener onOperatorClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case (R.id.btn_divide):
                    if (!hasOperator){
                        if (leftNum != 0){
                            numString.replace(0,numString.length(),callCalculation());
                            et_displayTotal.setText(numString);
                        }
                        setCalculation();
                        operator = '/';
                    }else{
                        break;
                    }
                    break;
                case (R.id.btn_multiply):
                    if (!hasOperator){
                        if (leftNum != 0){
                            numString.replace(0,numString.length(),callCalculation());
                            et_displayTotal.setText(numString);
                        }
                        setCalculation();
                        operator = '*';
                    }else{
                        break;
                    }
                    break;
                case (R.id.btn_subtract):
                    if (!hasOperator){
                        if (leftNum != 0){
                            numString.replace(0,numString.length(),callCalculation());
                            et_displayTotal.setText(numString);
                        }
                        setCalculation();
                        operator = '-';
                    }else{
                        break;
                    }
                    break;
                case (R.id.btn_add):
                    if (!hasOperator){
                        if (leftNum != 0){
                            numString.replace(0,numString.length(),callCalculation());
                            et_displayTotal.setText(numString);
                        }
                        setCalculation();
                        operator = '+';
                    }else{
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    };

    public View.OnClickListener onButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case (R.id.btn_clear):
                    numString.replace(0,numString.length(),"");
                    isNewCalculation = true;
                    et_displayTotal.setText("0");
                    break;
                case (R.id.btn_delete):
                    if (numString.length() > 1 ){
                        numString.deleteCharAt(numString.length()-1);
                        et_displayTotal.setText(numString);
                    }else{
                        numString.setLength(0);
                        et_displayTotal.setText("0");
                    }
                    break;
                case (R.id.btn_evaluate):
                    hasOperator = false;
                    numString.replace(0,numString.length(),callCalculation());
                    et_displayTotal.setText(numString);
                    break;
                default:
                    break;
            }
        }
    };

    public void setCalculation(){
        hasOperator = true;
        leftNum = Double.parseDouble(numString.toString());
        numString.setLength(0);
    }

    public String callCalculation(){
        rightNum = Double.parseDouble(numString.toString());
        double result = calculation.calculate(leftNum,rightNum,operator);
        return Double.toString(result);
    }




}