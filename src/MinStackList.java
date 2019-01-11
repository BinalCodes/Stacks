
public class MinStackList {
	static class Node{
		int val;
		int min;
		Node next;
		Node (int val, int min){
			this.val = val;
			this.min = min;
		}
	}
	Node top;
	public void push(int val) {
		if (top ==null) {
			Node n = new Node(val,val);
			top = n;
		}
		else {
			Node n = new Node(val, Math.min(val, top.min));
			n.next = top;
			top = n;
		}
		System.out.println("Pushed val "+top.val +" with min "+top.min);
	}
	public Node pop() {
		if(top ==null)
			return null;
		Node tmp = top;
		top.next = null;
		top = tmp;
		return tmp;
	}
	public int getMin() {
		if(top == null)
			return -1;
		return top.min;
	}
	public static void main(String[] args) {
		MinStackList stack = new MinStackList();
		stack.push(12);
		stack.push(31);
		stack.push(12);
		stack.push(1);
		stack.push(5);
		stack.push(14);
		System.out.println("Popped "+stack.pop().val);
		stack.push(4);
		System.out.println("Minimum element is "+stack.getMin());
		stack.push(1);
		stack.push(114);
		stack.push(23);
		stack.push(32);
	}

}
