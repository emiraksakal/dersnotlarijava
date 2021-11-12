

/**
 *
 * @author btek
 */
public class BinarySearchTree<Item> {

    private static void testDelete(BinarySearchTree<String> bst) {
        bst.traversePreOrder(bst.root);
        bst.deleteMin(bst.root);
        System.out.println("After Delete Min");
        bst.traversePreOrder(bst.root);

        bst.delete(50);
        System.out.println("After Delete 50");
        bst.traversePreOrder(bst.root);


        bst.root = bst.deleteMinRecursive(bst.root);
        System.out.println("After Delete Min Recursively");
        bst.traversePreOrder(bst.root);
        bst.delete(90);
        System.out.println("After Delete 90");
        bst.traversePreOrder(bst.root);
        bst.root = bst.delete2(bst.root, 75);
        System.out.println("After Delete2");
        bst.traversePreOrder(bst.root);
    }
    Node root;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.addNode(50, "boray");
        bst.addNode(25, "ali");
        bst.addNode(75, "timur");
        bst.addNode(10, "ebru");
        bst.addNode(30, "vahdet");
        bst.addNode(90, "cem");

        System.out.println("Traversing pre Order");
        bst.traversePreOrder(bst.root);

        System.out.println("Traversing in Order");
        bst.addNode(60, "harun");
        bst.traverseInOrder(bst.root);
//
        System.out.println("Print out paths");
//
        bst.pathLengths(bst.root, 0);

        // test search
        System.out.println(bst.Search(15));
        System.out.println(bst.SearchRecursive(bst.root, 15));
        

        // test Delete
        //testDelete(bst);
        System.out.println("This is cloned:");
        BinarySearchTree<String> bst2 = bst.clone();
        bst2.traverseInOrder(bst2.root);

        // test is BST
        System.out.println("Check tree:" + bst2.isBST1(bst.root));
        //testDelete(bst2);
        bst.traverseLevelOrder(bst.root);

        bst.range(bst.root, 5, 33);
        System.out.println("");
        int count = bst.countGreaterRoot(bst.root,bst.root.key);
        System.out.println(bst.root.key+" key "+"count: "+count);

    }

    /**
     * adds a new Node to the tree
     */


    public Node Search(int key) {
        Node focus = root;
        while (focus != null) {
            if (key < focus.key) {
                focus = focus.left;
            } else if (key > focus.key) {
                focus = focus.right;
            } else {
                return focus;
            }
        }
        return null;
    }


    public void addNode(int key, Item nm) {
        Node n = new Node(key, nm);
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

    public Node SearchRecursive(Node focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) //found return the node
        {
            return focus;
        } else if (key < focus.key) //check which side to go
        {
            return SearchRecursive(focus.left, key);
        } else //
        {
            return SearchRecursive(focus.right, key);
        }
    }


    // this one is from Sedgwewick's BST.java
    // it does delete recursively
    // it returns the same node as the input, but
    // the node which has key value is removed.
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

    // right most node
    public Node maxSearch(Node focus) {
        if (focus.right == null) {
            return focus;
        } else {
            return maxSearch(focus.right);
        }
    }

    // find the min, left node
    public Node minSearch(Node focus) {
        if (focus.left == null) {
            return focus;
        } else {
            return minSearch(focus.left);
        }
    }

    // deletes min, left most node
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

    // deletes min, left most node
    public void deleteMin(Node focus) {
        if (focus == null || root == null) {
            return;
        }
        Node tmp = focus;
        Node parent = null;
        while (tmp.left != null) {
            parent = tmp;
            tmp = tmp.left;
        }
        // now tmp.left is null. we reached minimum.
        // are we at the root;
        if (tmp == root) {
            root = tmp.right;
        }
        //
        parent.left = tmp.right;
        tmp.right = null;
    }

    // deletes max right most node.
    public Node deleteMaxRecursive(Node focus) {
        if (focus.right == null) {
            Node t = focus.left;
            focus.left = null;
            return t;
        }
        focus.right = deleteMaxRecursive(focus.right);
        return focus;
    }

    // this is my delete, case by case non-recursive
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
        } else if (focus.right == null) {
            if (focus == root) {
                root = focus.right;
            } else if (isLeftChild) {
                parent.left = focus.left;
            } else {
                parent.right = focus.left;
            }
        } else if (focus.left == null) {
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
            deleteMinRecursive(focus.right);
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
    // traverse the tree in pre Order. parent>left>right

    public void traversePreOrder(Node focus) {

        System.out.println(focus);
        if (focus.left != null) {
            traversePreOrder(focus.left);
        }
        if (focus.right != null) {
            traversePreOrder(focus.right);
        }
    }

    // traverse the tree in Order, left-> parent->right
    public void traverseInOrder(Node focus) {
        if (focus.left != null) {
            traverseInOrder(focus.left);
        }
        System.out.println(focus);
        if (focus.right != null) {
            traverseInOrder(focus.right);
        }
    }

    public void traverseLevelOrder(Node focus) {
        java.util.LinkedList<Node> que = new java.util.LinkedList<Node>();
        que.add(focus);
        while (!que.isEmpty()) {
            Node d = que.removeFirst();
            if (d.left != null) {
                que.addLast(d.left);
            }
            if (d.right != null) {
                que.addLast(d.right);
            }
            System.out.println(d);
        }
    }

    //mirror the BST
    private void mirror(Node node) {
        if (node != null) {
            // do the sub-trees
            mirror(node.left);
            mirror(node.right);
            // swap the left/right pointers
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    //checks whether the tree is a bst tree
    public boolean isBST1(Node focus) {
        if (focus == null) {
            return (true);
        }
        // do the subtrees contain values that do not
        // agree with the node?
        if (focus.left != null && maxSearch(focus.left).key > focus.key) {
            return (false);
        }
        if (focus.right != null && minSearch(focus.right).key <= focus.key) {
            return (false);
        }

        if (!isBST1(focus.left) || !isBST1(focus.right)) {
            return (false);
        }

        return true;
    }

    public BinarySearchTree<Item> clone() {
        BinarySearchTree<Item> t = new BinarySearchTree<Item>();
        t.root = cloneSubTree(this.root);
        return t;
    }

    //Clone nodes under a root.
    public Node cloneSubTree(Node focus) {
        if (focus == null) {
            return null;
        } else {
            Node t = new Node(focus.key, focus.data);
            t.left = cloneSubTree(focus.left);
            t.right = cloneSubTree(focus.right);
            return t;
        }
    }

    // method calculates number of nodes in the tree
    public int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            int a = size(n.left) + 1;
            int b = size(n.right);
            return (a + b);
        }
    }

    //method calculates path lengths (depth) of each leaf node.
    public void pathLengths(Node node, int count) {
        if (node.left == null && node.right == null) {
            System.out.println("Leaf reached: " + node + " Path: " + count);
            //return 0;
        } else {
            if (node.left != null) {
                pathLengths(node.left, ++count);
                count--;
            }
            if (node.right != null) {
                pathLengths(node.right, ++count);
            }
            count--;
        }
    }



    public void range(int lo, int hi){
        range(root, lo, hi);
    }

    private void range(Node focus, int lo, int hi) {
        if (focus == null) {
            return;
        }
        if (lo < focus.key) {
            range(focus.left, lo, hi);
        }
        if (lo <= focus.key && focus.key <= hi  ) {
            System.out.print(focus.key+ " ");

        }
        if (hi > focus.key) {
            range(focus.right, lo, hi);
        }

    }

    public int floor(int key) {
        Node x = floor(root, key);
        if (x == null) return Integer.MIN_VALUE; // no such key
        else return x.key;
    }
    private Node floor(Node focus, int key) {
        if (focus == null) return null;

        // exact match  return node
        if (focus.key == key)
            return focus;

        // floor is on the left
        if (focus.key <  key)
            return floor(focus.left, key);

        // no more left, now go to the right
        Node t = floor(focus.right, key);
        if (t != null)
            return t;
        else
            return focus;
    }



    public class Node<Item> {

        int key;
        Item data; // change this for other objects
        Node<Item> left = null;
        Node<Item> right = null;

        public Node(int key, Item name) {
            this.key = key;
            this.data = name;
        }

        @Override
        public String toString() {
            return ("Node(k= " + key + ", name= " + data.toString() + ")");
        }
    }

    public int countGreaterRoot(Node node,int data){
        if(node == null){
            return 0;
        }

        int countLeft = countGreaterRoot(node.left,data);
        int countRight = countGreaterRoot(node.right,data);

        return (node.key > data ? 1 : 0) + countLeft + countRight;

    }
}
