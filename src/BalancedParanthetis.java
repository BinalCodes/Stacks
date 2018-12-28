import java.util.Stack;

/*
 * Given a string with alphanumeric characters and paranthesis 
 * return a string with balanced paranthesis
 * input : bi((na()l
 * output : bi(na)l
 * 
 */
public class BalancedParanthetis {

	public static void main(String[] args) {
		String s = "bi((na()l";
		System.out.println("Balanced string is "+getBalancedString(s));
	}
	public static String getBalancedString(String input) {
		char[] charArr = input.toCharArray();
		Stack<Integer> posStack = new Stack<Integer>();
		for(int i =0; i<input.length(); i++) {
			if(charArr[i] == '(') {
				posStack.push(i);
			}
			else if (charArr[i] == ')') {
				if (posStack.isEmpty()) {
					charArr[i]='\0';
				}
				posStack.pop();
			}
		}
		while (!posStack.isEmpty()) {
			charArr[posStack.pop()] = '\0';
		}
		
		return new String(charArr);
	}
}
