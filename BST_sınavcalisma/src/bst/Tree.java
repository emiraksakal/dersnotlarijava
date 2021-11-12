package bst;

import java.util.Stack;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public Node Search(int key){
        Node focus = root;
        while (focus!=null){
            if(key<focus.key) focus = focus.left;
            else if (key>focus.key) focus = focus.right;
            else return focus;
        }
        return null;
    }

    /*void addNode1(int key) {
        Node n = new Node(key);
        if (root==null)
            root=n;
        Node tmp=root;
        Node parent=root;
        while (tmp!=null) {
            parent = tmp;
            if (key<tmp.key)
                tmp = tmp.left;
           else if (key>tmp.key)
                tmp=tmp.right;
            if (key<parent.key)
                parent.left=n;
            parent.right=n;

        }
    }*/


    public void addNode(int key) {
        Node n = new Node(key);
        // if the tree is empty
        if (root == null) {
            root = n;
        } else {
            Node tmp = root;
            Node parent = root;
            while (tmp != null) {
                parent = tmp;
                if (key < tmp.key) {
                    tmp = tmp.left;
                } else if (key >= tmp.key) {
                    tmp = tmp.right;
                }
            }
            if (key < parent.key) {
                parent.left = n;
            } else {
                parent.right = n;
            }
        }
    }
    public void traverseInOrder(Node focus){
        if(focus.left != null)
            traverseInOrder(focus.left);
        System.out.println(focus);
        if(focus.right != null)
            traverseInOrder(focus.right);
    }

    public void decreasingOrder(Node focus){
        if(focus.right != null)
            decreasingOrder(focus.right);
        System.out.println(focus);
        if(focus.left != null)
            decreasingOrder(focus.left);
    }


   /* int lowerThan(int x) {
        Node fakeroot = root;
        if (fakeroot.key<x){
            fakeroot=fakeroot.right;
            return fakeroot.key;
        }
        else {fakeroot=fakeroot.right;}
        return -8;
    }
*/

    /* int sumlargerthanx(int x) {
    }                          //  bst de girdiğim değerlerden büyük sayıları bulup toplayacak
     */

    /* int numberOfOddNodes() {
    //                              bst deki tek sayılardan kaç tane olduğunu yazacak.
     */

    public void traversePreOrder(Node focus){
        if(focus.left != null)
            traversePreOrder(focus.left);
        if(focus.right != null)
            traversePreOrder(focus.right);
        System.out.println(focus);
    }

    public Node minSearch(Node focus) {
        if (focus.left == null) {
            return focus;
        } else {
            return minSearch(focus.left);
        }
    }

    public Node SearchRecursive(Node focus, int key){
        if (focus == null)
            return null;
        if(focus.key == key) //found return the node
            return focus;
        else if (key<focus.key)  //check which side to go
            return SearchRecursive(focus.left,key);
        else  //
            return SearchRecursive(focus.right,key);
    }

    public int size(Node focus) {
        if (focus ==null)     return 0;
        else
            return(size(focus.left) + 1 + size(focus.right));
    }

    private void deleteMin(Node focus) {
        if(focus == null || root == null)
            return;
        Node parent = null;
        while(focus.left != null){
            parent = focus;
            focus = focus.left;
        }
        // now focus.left is null. we reached minimum.
        // are we at the root;
        if (focus == root){
            root = focus.right;
        }
        //
        parent.left = focus.right;
        focus.right = null; // to clean the reference
    }

    public Node deleteMaxRecursive(Node focus) {
        if (focus.right == null) {
            Node t = focus.left;
            focus.left = null;
            return t;
        }
        focus.right = deleteMaxRecursive(focus.right);
        return focus;
    }

    public boolean delete(int key) {
        // use double linked nodes to simplify
        // start with the simple case of leaf node
        Node focus = root;
        Node parent = null;
        boolean isLeftChild = false;
        // below loop finds the parent of the key and also
        // registers whether it is left or right child.
        while (focus != null && focus.key != key) {
            parent = focus;
            if (key < focus.key) {
                focus = focus.left;
                isLeftChild = true;
            } else if (key > focus.key) {
                focus = focus.right;
                isLeftChild = false;
            }
        }
        if (focus == null) {
            return false;
        }

        if (focus.left == null && focus.right == null) {
            if (focus == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (focus.right == null) {
            if (focus == root) {
                root = focus.right;
            } else if (isLeftChild) {
                parent.left = focus.left;
            } else {
                parent.right = focus.left;
            }
        }
        else if (focus.left == null) {
            if (focus == root) {
                root = focus.left;
            }
            if (isLeftChild) {
                parent.left = focus.right;
            } else {
                parent.right = focus.right;
            }
        } else {
            // we have two children.
            Node replacement = minSearch(focus.right);
            deleteMin(focus.right);
            // copy children
            replacement.left = focus.left;
            replacement.right = focus.right;
            if (focus == root) {
                root = replacement;
            } else if (isLeftChild) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
        }
        return true;
    }


    public Node deleteMinRecursive(Node focus) {
        if (focus.left == null) {
            Node t = focus.right;
            // just before delete make the ref null
            //focus.right = null;
            return t;
        }
        focus.left = deleteMinRecursive(focus.left);
        return focus;
    }

    public Node delete2(Node focus, int key) {
        if (focus == null) {
            return null;
        }
        if (key < focus.key) {
            focus.left = delete2(focus.left, key);
        } else if (key > focus.key) {
            focus.right = delete2(focus.right, key);
        } else {
            if (focus.right == null) {
                // Node tmp = focus.left; focus = null;
                return focus.left;
            }
            if (focus.left == null) {
                return focus.right;
            }
            Node t = focus;
            focus = minSearch(t.right);
            focus.right = deleteMinRecursive(t.right);
            focus.left = t.left;
        }
        return focus;
    }





    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        tree.addNode(10);



     System.out.println("in order:");
     tree.traverseInOrder(tree.root);
        System.out.println("pre order:");
     tree.traversePreOrder(tree.root);
        System.out.println("min search: ");
     tree.minSearch(tree.root);  //çıktı vermedi
        System.out.println("search for 3");
        tree.Search(3);
        tree.SearchRecursive(tree.root,3);
        System.out.println("size");
        tree.size(tree.root);
        tree.delete(8);
        System.out.println("After Delete 90");
        tree.traversePreOrder(tree.root);
        System.out.println("15 var mı yok mu");
        System.out.println(tree.Search(15));
        System.out.println("decreasing order");
        tree.decreasingOrder(tree.root);
       // System.out.println("lower than 5");
       // tree.lowerThan(5);


    }
}
