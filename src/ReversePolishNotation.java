import java.util.Stack;

public class ReversePolishNotation {
	
	/*
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 */

	public static void main(String[] args) {
		String[] expression = {"4", "13", "5", "/", "+"};
		String operator = "+-*/";
		System.out.println(evaluateExpr(expression,operator));
	}
	public static int evaluateExpr (String[] expression,String operator ) {
		int returnValue = 0;
		Stack<String> operation = new Stack<String>();
		
		for(String s: expression) {
			if (!operator.contains(s)) //its an operator and not an operand so pop out of the stack
				operation.push(s);
			else {
				int secondOperand = Integer.valueOf(operation.pop());
				int firstOperand = Integer.valueOf(operation.pop());
				switch(s) {
				case "+" : 
					operation.push(String.valueOf(firstOperand + secondOperand));
					break;
				case "-":
					operation.push(String.valueOf(firstOperand - secondOperand));
					break;
				case "*":
					operation.push(String.valueOf(firstOperand * secondOperand));
					break;
				case "/":
					operation.push(String.valueOf(firstOperand / secondOperand));
					break;
				default :
					System.out.println("Operation not supported ");
					break;
				}
			}
		}
		return (Integer.valueOf(operation.pop()));
	}

}
