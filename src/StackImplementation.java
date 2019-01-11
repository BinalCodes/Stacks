import java.io.*;
import java.util.*;

/*
 * stack
 *
 * push - adds element to stack
 * pop  - removes and returns element from stack
 * min  - returns the minimum value in stack (does not modify stack)
 *
 */

class StackImplementation {
    class Node{
    	int val;
    	int min;
    	Node(int val,int min){
    		this.val = val;
    		this.min = min;
    	}
    }
	
	Node[] elements;
    int size;
    int top;
    StackImplementation(int size){
      this.size = size;
      top = -1;
      elements = new Node[size];
    }
  
   /* O(1) */
   public void push(int num){
      //System.out.println("Top value "+top);
	   if (top >= size-1){
        System.out.println("Stack is full cannot insert anymore elements");
        return;
      }
	   //System.out.println("Top first .. "+top);
      if(top !=-1)  {
    	  //System.out.println("Top second .. "+top);
    	  Node n = new Node(num,Math.min(num,elements[top].min));
    	  elements[++top] = n;
      }
      else {
    	  Node n = new Node(num,num);
		  elements[++top] = n;
      }
      System.out.println("Inserted with top value as "+num);
    }
  
   /* O(1) */
	 public int pop(){
	     if(elements.length == 0)
	       return -1;
	     return elements[top--].val;
	 }
	 public int getMin() {
		 if(top < 0)
			 return -1;
		 return elements[top].min;
	 }
	  public static void main(String[] args) {
	    StackImplementation obj = new StackImplementation(10);
	    obj.push(31);
	    obj.push(12);
	    obj.push(1);
	    obj.push(5);
	    obj.push(14);
	    obj.push(4);
	    obj.push(1);
	    obj.push(114);
	    obj.push(23);
	    obj.push(32);
	    obj.push(-1);
	    System.out.println(obj.pop());
	    System.out.println(obj.getMin());
	  }
	}
