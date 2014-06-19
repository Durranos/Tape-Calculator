package com.kearney.calculator;

import java.util.EmptyStackException;

import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The CalcButtons.java class is responsible for creating the calculator's
 * buttons and add button listeners to each button. In addition, it is also responsible
 * for capturing user input and passing the completed string to Calculate.java
 */
public class CalcButtons extends Activity{
	public Activity activity;
	
	// Calculator Buttons 0 - 9, +, -, *, /, =, ., (, ), C, CE
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button buttonPlus;
	Button buttonMinus;
	Button buttonMult;
	Button buttonDivide;
	Button buttonEquals;
	Button buttonDecimal;
	Button buttonErase;
	Button buttonBackspace;
	Button leftParen;
	Button rightParen;
	
	// The output text box
	TextView textScreen;
	
	// String array that keeps track of each line calculation
	// This is maintained so that if the user clears a line, I can output
	// each line back to the text box with each line on its own line
	String lines[] = new String[500];
	
	// Input string, stored to each index in lines[]
	String input = "";
	
	// The output string that is sent to the textScreen
	String output = "";
	
	// Increments each time the user hits the = sign
	int currentLineNum = 0;
	
	// The final answer for each line
	double total = 0;
	
	// The Calculate class object
	Calculate calc;
	
	/**
	 * Public constructor for CalcButtons
	 * Takes an Activity object as input which it needs in order to use findViewByID
	 * @param _activity
	 */
	public CalcButtons(Activity _activity){
		calc = new Calculate();
		this.activity = _activity;
		createButtons();
		addListeners();
		
	}
	
	/**
	 * Creates each button used by the Calculator App
	 * @param none
	 * @return void
	 */
	private void createButtons(){
		button0 = (Button) this.activity.findViewById(R.id.button0);
		button1 = (Button) this.activity.findViewById(R.id.button1);
		button2 = (Button) this.activity.findViewById(R.id.button2);
		button3 = (Button) this.activity.findViewById(R.id.button3);
		button4 = (Button) this.activity.findViewById(R.id.button4);
		button5 = (Button) this.activity.findViewById(R.id.button5);
		button6 = (Button) this.activity.findViewById(R.id.button6);
		button7 = (Button) this.activity.findViewById(R.id.button7);
		button8 = (Button) this.activity.findViewById(R.id.button8);
		button9 = (Button) this.activity.findViewById(R.id.button9);
		leftParen       = (Button) this.activity.findViewById(R.id.leftParen);
		rightParen      = (Button) this.activity.findViewById(R.id.rightParen);
		buttonPlus      = (Button) this.activity.findViewById(R.id.buttonPlus);
		buttonMinus     = (Button) this.activity.findViewById(R.id.buttonMinus);
		buttonMult      = (Button) this.activity.findViewById(R.id.buttonMult);
		buttonDivide    = (Button) this.activity.findViewById(R.id.buttonDivide);
		buttonEquals    = (Button) this.activity.findViewById(R.id.buttonEquals);
		buttonDecimal   = (Button) this.activity.findViewById(R.id.buttonDecimal);
		buttonErase	    = (Button) this.activity.findViewById(R.id.buttonErase);
		buttonBackspace = (Button) this.activity.findViewById(R.id.buttonBackspace);
		textScreen = (TextView) this.activity.findViewById(R.id.stuff);
		textScreen.setMovementMethod(new ScrollingMovementMethod());
	}
	
	// Adds listener events to each of the buttons
	/**
	 * Adds listener events to each of the buttons
	 * @param none
	 * @return void
	 */
	private void addListeners(){
		
		// Button 0
		button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button0.getText().toString();
				getInput(s);
			}
		});

		// Button 1
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button1.getText().toString();
				getInput(s);
			}
		});

		// Button 2
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button2.getText().toString();
				getInput(s);
			}
		});

		// Button 3
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button3.getText().toString();
				getInput(s);
			}
		});

		// Button 4
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button4.getText().toString();
				getInput(s);
			}
		});

		// Button 5
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button5.getText().toString();
				getInput(s);
			}
		});

		// Button 6
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button6.getText().toString();
				getInput(s);
			}
		});

		// Button 7
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button7.getText().toString();
				getInput(s);
			}
		});

		// Button 8
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button8.getText().toString();
				getInput(s);
			}
		});

		// Button 9
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = button9.getText().toString();
				getInput(s);
			}
		});
		
		// Left Parentheses
		leftParen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = leftParen.getText().toString();
				getInput(s);
			}
		});
		
		// Right Parentheses
		rightParen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = rightParen.getText().toString();
				getInput(s);
			}
		});
		
		// Addition Button
		buttonPlus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = buttonPlus.getText().toString();
				getInput(s);
			}
		});
		
		// Subtraction Button
		buttonMinus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = buttonMinus.getText().toString();
				getInput(s);
			}
		});
		
		// Multiplication Button
		buttonMult.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = buttonMult.getText().toString();
				getInput(s);
			}
		});
		
		// Division Button
		buttonDivide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = buttonDivide.getText().toString();
				getInput(s);
			}
		});
		
		// Equals Button
		buttonEquals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// If the user does not enter a valid equation
				try{
					// Calculate the answer
					total = calc.calc(input);
					// Report answer to screen
					getInput(" = " + total + "\n");
					// Increment to the next line
					currentLineNum++;
				// Catch the error, don't let the app crash
				}catch(EmptyStackException e){
					System.out.println("There was an error " + e);
					System.out.println("Input: " + input);
					System.out.println("Current Line Number: " + currentLineNum);
					System.out.println("Number Stack Size: " + calc.nums.size());
					System.out.println("Operator Stack Size: " + calc.operators.size());
				}
				
				// Call erase function
				calc.erase();
				
				// Clear the input string
				input = "";
				
				// Empty the number stack
				while(calc.nums.isEmpty() != true)
					calc.nums.pop();
				
				// Empty the operator stack
				while(calc.operators.isEmpty() != true)
					calc.operators.pop();
			}
		});
		
		// Decimal Point Button
		buttonDecimal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String  s = buttonDecimal.getText().toString();
				getInput(s);
			}
		});
		
		// Erase Button - clears all lines
		buttonErase.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(output.length() != 0){
					textScreen.setText("");
					erase();
				}
			}
		});
		
		// Backspace Button - clears the current line
		buttonBackspace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(input.length() > 0){
					input  = "";
					lines[currentLineNum] = input;
					textScreen.setText("");
						
					for(int i = 0; i < currentLineNum; i++)
						textScreen.append(lines[i]);
				}
			}
		});
	}
	
	/**
	 * Takes input from the calculator buttons and saves them to a string,
	 * which is passed to Calculate.java once user hits the = sign
	 * @param line
	 * @return void
	 */
	private void getInput(String line){
		input = input + line;
		output = output + input;
		lines[currentLineNum] = input;
		textScreen.append(line);
		
		// If the users has entered 4 lines of calculations, auto scroll down
		if(textScreen.getLineCount() > 4){
			int scroll_amount = (int) (textScreen.getLineCount() * textScreen.getLineHeight()) - (textScreen.getBottom() - textScreen.getTop());
			textScreen.scrollTo(0, scroll_amount);
		}
	}
	
	/**
	 * Erases all data
	 * @param none
	 * @return void
	 */
	private void erase(){
		output = "";
		input = "";
		total = 0;
		
		// Clears currentNum and current convertedNum in the Calculate class
		calc.erase();
		
		// Empty the number stack
		while(calc.nums.isEmpty() != true)
			calc.nums.pop();
		
		// Empty the operator stack
		while(calc.operators.isEmpty() != true)
			calc.operators.pop();
		
		// Reset the lines[] array
		for(int i = 0; i < lines.length; i++)
			lines[i] = " ";
		
		System.out.println("Nums Size: " + calc.nums.size());
		System.out.println("Operator Size: " + calc.operators.size());
		System.out.println("Line Size: " + lines.length);
	}
}
