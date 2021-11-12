package lab;

import java.util.NoSuchElementException;

public class StackArray {
    int data[];
    int top;

    StackArray(int N) {
        data=new int[N];
        top=-1;
    }

    boolean isFull() {
        if (top==data.length-1) {
            return true;
        } return false;
    }

    void push(int element){
        if (!isFull()){
            top++;
            data[top]=element;
        }
    }

    boolean isEmpty() {
        return top==-1;
    }

    public int pop() {
        if (!isEmpty()) {
            throw new NoSuchElementException();
        } else top--;
        return data[top+1];
    }

    static  void swapTwoMost(StackArray stack) {
        int topFirst=0 , topSecond=0;
        if (!stack.isEmpty()) {
            topFirst=stack.pop();
        }if (!stack.isEmpty()) {
            topSecond=stack.pop();
        }
        stack.push(topFirst);
        stack.push(topSecond);
    }

    int peek (){
        if (!isEmpty()) {
            return data[top];
        } else return -1;
    }

    public static void printStack(StackArray stack) {
        if (stack.isEmpty()) {
            return;
        }
        int x = stack.peek();
        stack.pop();
        printStack(stack);
        System.out.println(x + " ");
        //stack.push(x);
    }

    public static boolean checkPal(String s){
        StackArray stack = new StackArray(s.length());
        for (int i=0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }
        String revereString = "";
        while(!stack.isEmpty()){
            revereString = revereString + stack.pop();
        }
        if(s.equals(revereString)){
            System.out.println("The string is a palindrome");
            return true;
        }else{
            System.out.println("The string is not a palindrome");
            return false;
        }
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    

}
