package com.example.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;

import java.util.regex.*;

public class MainActivity extends AppCompatActivity {

    //Declarations for all elements
    Button btn_clear, btn_delete, btn_divide, btn_multiply, btn_add, btn_posAndNeg, btn_subtract, btn_decimal,
            btn_evaluate, btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven,
            btn_eight, btn_nine;

    TextView tv_displayTotal;

    //Instance objects for calculations and strings
    Calculations calculation = new Calculations();
    StringBuilder currentNumber = new StringBuilder("0");

    //Declare variables for equation
    double leftNum, rightNum;
    char operator;

    //Declare Boolean variables for validating buttons
    boolean hasOperator = false;
    boolean zeroFirst = false;
    boolean isUndefined = false;

    //Declare digit limit for screen
    int textViewLimit = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instance the buttons
        tv_displayTotal = findViewById(R.id.tv_displayTotal);
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

        //Set all listeners to buttons
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
        btn_decimal.setOnClickListener(onNumberClicked);

        btn_clear.setOnClickListener(onSpecialButtonClicked);
        btn_delete.setOnClickListener(onSpecialButtonClicked);
        btn_evaluate.setOnClickListener(onSpecialButtonClicked);
        btn_posAndNeg.setOnClickListener(onSpecialButtonClicked);

        btn_divide.setOnClickListener(onOperatorClicked);
        btn_multiply.setOnClickListener(onOperatorClicked);
        btn_subtract.setOnClickListener(onOperatorClicked);
        btn_add.setOnClickListener(onOperatorClicked);

        tv_displayTotal.setText(currentNumber);
    }//end OnCreate

    public View.OnClickListener onNumberClicked = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            //Check the previous calculation is finished and empty the current number
            if (isUndefined) {
                currentNumber.replace(0, currentNumber.length(),"0");
            }
            isUndefined = false;

            //Check if the the first digit is a 0 in an integer (no decimal)
            if (Pattern.matches("^0+", currentNumber) && !currentNumber.toString().contains(".") || currentNumber.toString().contains("-0")) {
                zeroFirst = true; //To avoid having 0 before other digits ie (00,01,etc)
            }

            //Only make digit buttons available if under the screen limit
            if (currentNumber.length() < textViewLimit) {
                switch (view.getId()) { //Switch through each digit and decimal buttons
                    case (R.id.btn_zero):
                        if (zeroFirst) {//If there is a zero at beginning and digit is clicked, replace 0 with current digit
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "0");
                        } else {//if theres no zero at beginning append the digit
                            currentNumber.append("0");
                        }
                        break;
                    case (R.id.btn_one):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "1");
                        } else {
                            currentNumber.append("1");
                        }
                        break;
                    case (R.id.btn_two):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "2");
                        } else {
                            currentNumber.append("2");
                        }
                        break;
                    case (R.id.btn_three):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "3");
                        } else {
                            currentNumber.append("3");
                        }
                        break;
                    case (R.id.btn_four):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "4");
                        } else {
                            currentNumber.append("4");
                        }
                        break;
                    case (R.id.btn_five):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "5");
                        } else {
                            currentNumber.append("5");
                        }
                        break;
                    case (R.id.btn_six):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "6");
                        } else {
                            currentNumber.append("6");
                        }
                        break;
                    case (R.id.btn_seven):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "7");
                        } else {
                            currentNumber.append("7");
                        }
                        break;
                    case (R.id.btn_eight):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "8");
                        } else {
                            currentNumber.append("8");
                        }
                        break;
                    case (R.id.btn_nine):
                        if (zeroFirst) {
                            currentNumber.replace(currentNumber.length() - 1, currentNumber.length(), "9");
                        } else {
                            currentNumber.append("9");
                        }
                        break;
                    case (R.id.btn_decimal)://Check if current number already contains a decimal
                        if (!currentNumber.toString().contains(".")) {
                            if (currentNumber.length() == 0) {//If decimal is first button clicked, append 0 with it
                                currentNumber.append("0.");
                            } else {
                                currentNumber.append(".");
                            }
                        }
                        break;
                    default:
                        break;
                }

                //Display current number
                tv_displayTotal.setText(currentNumber);
                zeroFirst = false;//To be able to add digits
            }
        }
    };//end OnNumberClicked

    public View.OnClickListener onOperatorClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Check if there is already an operator hit or if there needs to be a new calc done (ie if undefined)
            if (!hasOperator && !isUndefined) {
                switch (view.getId()) {//Switch through the four ops
                    case (R.id.btn_divide):
                        setCalculation();//Call calculation method
                        operator = '/';//Assign operator
                        break;
                    case (R.id.btn_multiply):
                        setCalculation();
                        operator = '*';
                        break;
                    case (R.id.btn_subtract):
                        setCalculation();
                        operator = '-';
                        break;
                    case (R.id.btn_add):
                        setCalculation();
                        operator = '+';
                        break;
                    default:
                        break;
                }
                //Display operator in the text view
                tv_displayTotal.setText(String.format("%s %c", tv_displayTotal.getText(), operator));
            }
        }
    };//end onOperatorClicked

    public View.OnClickListener onSpecialButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){//Switch for all special buttons
                case (R.id.btn_posAndNeg):
                    if (!isUndefined) { //Check to see if undefined so it doesn't show up
                        if (!currentNumber.toString().contains("-")) { //check if number is already negative, take it away
                            currentNumber.insert(0, "-");
                        } else {
                            currentNumber.deleteCharAt(0);
                        }
                    }
                    tv_displayTotal.setText(currentNumber);
                    break;
                case (R.id.btn_clear):
                    currentNumber.replace(0, currentNumber.length(),"0");//Remove the string and replace with 0
                    hasOperator = false;//reset validation variables
                    isUndefined = false;
                    tv_displayTotal.setText(currentNumber);
                    break;
                case (R.id.btn_delete)://Regex to check if the currentNumber is positive
                    if (isUndefined){
                        currentNumber.replace(0, currentNumber.length(),"0");
                        isUndefined = false;
                    }
                    if (Pattern.matches("^[+]?([.]\\d+|\\d+([.]\\d+)?)$", currentNumber)){
                        if (currentNumber.length() > 1 ){//if positive deleting last number creates a 0
                            currentNumber.deleteCharAt(currentNumber.length()-1);
                        }else{
                            currentNumber.replace(0, currentNumber.length(),"0");
                            hasOperator = false;
                            isUndefined = false;
                        }
                    }else{//when negative deleting last 2 digits creates 0
                        if (currentNumber.length() > 2 ){
                            currentNumber.deleteCharAt(currentNumber.length()-1);
                            tv_displayTotal.setText(currentNumber);
                        }else{
                            currentNumber.replace(0, currentNumber.length(),"0");
                            hasOperator = false;
                            isUndefined = false;
                        }
                    }
                    tv_displayTotal.setText(currentNumber);
                    break;
                case (R.id.btn_evaluate):
                    if (hasOperator && currentNumber.length() != 0){ //Check that there is an operator and the current number (which will be right) has value
                        hasOperator = false; //set the operator to false so more calculations can be made
                        currentNumber.replace(0, currentNumber.length(),callCalculation());//replace the number string with the returned value from the call calculation method
                        if (currentNumber.length() > textViewLimit){
                            currentNumber.delete(textViewLimit,currentNumber.length());
                        }
                        tv_displayTotal.setText(currentNumber);
                    }
                    break;
                default:
                    break;
            }
        }
    };//end onSpecialButtonClicked

    public void setCalculation(){
        hasOperator = true; //set having operator as true so no other can be chosen

        //Check if theres anything in the current number and set to the left Number variable
        if (currentNumber.length() != 0){
            leftNum = Double.parseDouble(currentNumber.toString());
        }else { //if nothing set the left num to 0
            leftNum = 0;
        }
        currentNumber.replace(0, currentNumber.length(),"0"); //Set current number to nothing to make it available for the right Number
    }

    public String callCalculation(){
        String display;
        double result;
        //Set the right number to the digit string
        rightNum = Double.parseDouble(currentNumber.toString());

        //Check if the equation will result in undefined IE dividing by 0
        if (rightNum == 0 && operator == '/'){
            isUndefined = true;
            display = "NaN"; //
        }else{//if not call the calculate method from calculation class with numbers and operators
            result = calculation.calculate(leftNum,rightNum,operator);
            if (result % 1 == 0){//Check if the returned value has no digits after decimal and either return int or double
                display = Integer.toString((int)result);
            }else{
                display = Double.toString(result);
            }
        }
        return display;
    }
}