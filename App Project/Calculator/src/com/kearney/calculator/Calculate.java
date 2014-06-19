package com.kearney.calculator;

import java.util.Stack;

/**
 * The Calculate class finds the total to the user's calculation
 */
public class Calculate {
	
	// The current answer - saved to the num stack till final answer is found
	private double answer;
	// Top of the operator stack is saved here
	private char c;
	// This string is continuously added to until an operator is encountered
	private String currentNum;
	// Converted String to Integer Number
	private double convertedNum;
	
	// The num and operators stacks
	Stack<Double> nums;
	Stack<Character> operators;
	
	/**
	 * The Calculate Constructor
	 * Creates the num and operator stacks and initializes its global variables
	 * @param none
	 * @return void
	 */
	public Calculate(){
		nums = new Stack<Double>();
		operators = new Stack<Character>();
		answer = 0;
		c = ' ';
		currentNum = "";
		convertedNum = 0;
	}
	
	// Takes in a string and calculates the answer
	/**
	 * Takes the input string and calculates the final answer
	 * @param s:String (User Input String)
	 * @return answer:Integer
	 */
	public double calc(String s){
		System.out.println("Input String: " + s);
		// Push values onto correct stacks and handle parentheses
		// If any parenthese, solve the inside of the parentheses
		// and push onto the stack
		for(int i = 0; i < s.length(); i++){
			c = s.charAt(i);
			System.out.println(c);
			//answer = c;
			
			// Any Operator other than right parentheses push onto operator stack
			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '('){
				System.out.println("Saw the operator: " + c);
				operators.push(c);
				currentNum = "";
			}
			// A right parentheses was seen pop all operators till a left parentheses is encountered
			else if(c == ')'){
				currentNum = "";
				while(c != '('){
					System.out.println("Saw the operator: " + c);
					answer = findAnswer();
					System.out.println("The answer so far is: " + answer);
					
					c = operators.peek();
					if(c == '(')
						operators.pop();
				}
			}
			// Else a number push it onto the num stack
			else{
				if(currentNum.compareTo("") != 0)
					nums.pop();
				currentNum = currentNum + c;
				convertedNum = Double.parseDouble(currentNum);
				//convertedNum = Integer.parseInt(currentNum);
				nums.push(convertedNum);
				System.out.println("Saw a number: " + convertedNum);
			}
			System.out.println("Nums Size: " + nums.size());
			System.out.println("Operators Size: " + operators.size());
		}
		
		System.out.println("Nums Size: " + nums.size());
		System.out.println("The parentheses have been dealth with...calculating final answer");
		// While num stack size is not equal 1
		// The total will be calculated once num stack = 1
		// This function is only called once all parentheses have been dealt with
		while(nums.size() != 1){
			answer = findAnswer();
			System.out.println("Finding final answer: " + answer);
		}
		System.out.println("Final Answer: " + answer);
		answer = nums.pop();
			
		return answer;
	}
	
	/**
	 * Pops operators and numbers off each stack until there is only one variable
	 * stored in the num stack.
	 * Returns the answer back to the calc() function
	 * @param none
	 * @return answer:Integer
	 */
	private double findAnswer(){
		double answer = 0;
		double popedInts[] = new double[2];
		char op;
		op = operators.pop();
		System.out.println("Popped the operator: " + op);
		switch(op){
			case '+':
				popedInts[0] = nums.pop();
				popedInts[1] = nums.pop();
				answer = popedInts[1] + popedInts[0];
				nums.push(answer);
				break;
			case '-':
				popedInts[0] = nums.pop();
				popedInts[1] = nums.pop();
				answer = popedInts[1] - popedInts[0];
				nums.push(answer);
				break;
			case '*':
				popedInts[0] = nums.pop();
				popedInts[1] = nums.pop();
				answer = popedInts[1] * popedInts[0];
				nums.push(answer);
				break;
			case '/':
				popedInts[0] = nums.pop();
				popedInts[1] = nums.pop();
				answer = popedInts[1] / popedInts[0];
				nums.push(answer);
				break;
			default:
				break;
		}
		System.out.println("First Int: " + popedInts[1] + " Second Int: " + popedInts[0]);
		return answer;
	}
	
	/**
	 * Resets currentNum and convertedNum
	 * @param none
	 * @return void
	 */
	public void erase(){
		currentNum = "";
		convertedNum = 0;
	}
}
