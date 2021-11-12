package bst;

public class Node {

    int key;

    Node left = null;
    Node right = null;

    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return ("Node = " + key);
    }





   /* public Node search(int value) {
        if (key == value) {
            return this;
        } else if (key > value) {
            if (left != null) {
                return left.search(value);
            } else {
                return null;
            }
        } else if (right != null) {
            return right.search(value);
        } else {
            return null;
        }
    }*/



}
