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
    StringBuilder numString = new StringBuilder("");

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

        btn_zero.setOnClickListener(onButtonClicked);
        btn_one.setOnClickListener(onButtonClicked);
        btn_two.setOnClickListener(onButtonClicked);
        btn_three.setOnClickListener(onButtonClicked);
        btn_four.setOnClickListener(onButtonClicked);
        btn_five.setOnClickListener(onButtonClicked);
        btn_six.setOnClickListener(onButtonClicked);
        btn_seven.setOnClickListener(onButtonClicked);
        btn_eight.setOnClickListener(onButtonClicked);
        btn_nine.setOnClickListener(onButtonClicked);

        btn_clear.setOnClickListener(onButtonClicked);
        btn_delete.setOnClickListener(onButtonClicked);
        btn_posAndNeg.setOnClickListener(onButtonClicked);
        btn_divide.setOnClickListener(onButtonClicked);
        btn_multiply.setOnClickListener(onButtonClicked);
        btn_subtract.setOnClickListener(onButtonClicked);
        btn_add.setOnClickListener(onButtonClicked);
        btn_decimal.setOnClickListener(onButtonClicked);
        btn_evaluate.setOnClickListener(onButtonClicked);




    }//end OnCreate

    public View.OnClickListener onButtonClicked = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            String buttonValue = "";
            switch (view.getId()){
                case (R.id.btn_zero):
                    buttonValue = "0";
                    break;
                case (R.id.btn_one):
                    buttonValue = "1";
                    break;
                case (R.id.btn_two):
                    buttonValue = "2";
                    break;
                case (R.id.btn_three):
                    buttonValue = "3";
                    break;
                case (R.id.btn_four):
                    buttonValue = "4";
                    break;
                case (R.id.btn_five):
                    buttonValue = "5";
                    break;
                case (R.id.btn_six):
                    buttonValue = "6";
                    break;
                case (R.id.btn_seven):
                    buttonValue = "7";
                    break;
                case (R.id.btn_eight):
                    buttonValue = "8";
                    break;
                case (R.id.btn_nine):
                    buttonValue = "9";
                    break;
                case (R.id.btn_clear):
                    numString.setLength(0);
                    buttonValue = "0";
                    break;
                case (R.id.btn_delete):
                    numString.deleteCharAt(numString.length()-1);
                    break;
                case (R.id.btn_posAndNeg):
                    buttonValue = "-";
                    numString.insert(0,buttonValue);
                    break;
                case (R.id.btn_divide):
                    leftNum = Double.parseDouble(numString.toString());
                    buttonValue = " /";
                    operator = '/';
                    break;
                case (R.id.btn_multiply):
                    leftNum = Double.parseDouble(numString.toString());
                    buttonValue = " *";
                    operator = '*';
                    break;
                case (R.id.btn_subtract):
                    leftNum = Double.parseDouble(numString.toString());
                    buttonValue = " -";
                    operator = '-';
                    break;
                case (R.id.btn_add):
                    leftNum = Double.parseDouble(numString.toString());
                    buttonValue = " +";
                    operator = '+';
                    break;
                case (R.id.btn_decimal):
                    buttonValue = ".";
                    break;
                default:
                    break;
            }
            setNumString(buttonValue);
        }
    };

    public void setNumString(String buttonValue){

        numString.append(buttonValue);

        et_displayTotal.setText(numString);
    }

    public void callCalculation(){
        calculation.calculate(leftNum,rightNum,operator);
    }

    public void getLeftNumber(){
        String stringLeftNumber = numString.toString();
    }



}