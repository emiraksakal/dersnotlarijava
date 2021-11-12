package lab;

public class GenericStack < Item > {
    private Item[] a;
    private int top;

    public GenericStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(Item item) {
        a[++top] = item;
    }

    public Item pop() {
        return a[--top];
    }

    public static void main(String[] args) {
        GenericStack < Student > gstack = new GenericStack < > (10);
        Student s1 = new Student("Ozay", 1111);
        gstack.push(s1);
        Student s2 = new Student("Mert", 2222);
        Student s3 = new Student("Büşra", 3333);
        Student s4 = new Student("John", 4444);
        gstack.push(s2);
        gstack.push(s3);
        gstack.push(s4);
        System.out.println(gstack.pop());
        System.out.println(gstack.pop());
        System.out.println(gstack.pop());
        System.out.println(gstack.pop());
    }
}

class Student {
    private int no;
    private String name;

    public Student(String name, int no) {
        this.no = no;
        this.name = name;
    }

    public String toString() {
        return "Student " + name + " No: " + no;
    }
}