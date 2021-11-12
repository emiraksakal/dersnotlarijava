package avl;

public class AVLTree<Item> {

    AVLNode<Item> root;

    public AVLTree() {
        root = null;
    }

    public int height(AVLNode<Item> d) {
        if (d == null) {
            return 0;
        } else {
            return d.height;
        }
    }

    //rotate focus. to right. replace it with left child //rotate to right
    public AVLNode<Item> rotateMyLeft(AVLNode focus) {
        AVLNode<Item> k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    //rotate focus left, replace it with right child //rotate to left
    public AVLNode<Item> rotateMyRight(AVLNode focus) {
        AVLNode<Item> k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<Item> doubleRotateLeftSide(AVLNode focus) { //LR
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode<Item> doubleRotateRightSide(AVLNode focus) { //RL
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    // Get Balance factor of node focus
    int getBalance(AVLNode<Item> focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }

    public AVLNode<Item> insert(AVLNode focus, Item data, int key) {
        if (focus == null) {
            focus = new AVLNode(data, key);
        } else if (key < focus.key) {
            focus.left = insert(focus.left, data, key);
            if (getBalance(focus) == 2) {
                if (key < focus.left.key) {
                    focus = rotateMyLeft(focus);
                } else {
                    focus = doubleRotateLeftSide(focus);
                }
            }
        } else if (key > focus.key) {
            focus.right = insert(focus.right, data, key);
            if (getBalance(focus) == 2) {
                if (key > focus.right.key) {
                    focus = rotateMyRight(focus);
                } else {
                    focus = doubleRotateRightSide(focus);
                }
            }
        } else {
            // key is equal to focus.key, update data
            focus.data = data;
        }

        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return focus;
    }

    public void insert(Item data, int key) {
        root = insert(root, data, key);
    }

    public void traverseLevelOrder(AVLNode focus) {
        if (focus == null) {
            focus = root; // if null is passed. print whole tree
        }
        java.util.LinkedList<AVLNode> que = new java.util.LinkedList<AVLNode>();
        que.add(focus);
        while (!que.isEmpty()) {
            AVLNode d = que.removeFirst();
            if (d.left != null) {
                que.addLast(d.left);
            }
            if (d.right != null) {
                que.addLast(d.right);
            }
            System.out.println(d);
        }
    }

    public int Ceil(AVLNode node, int input) {

        // Base case
        if (node == null) {
            return -1;
        }

        // We found equal key
        if (node.key == input) {
            return node.key;
        }

        // If root's key is smaller,
        // ceil must be in right subtree
        if (node.key < input) {
            return Ceil(node.right, input);
        }

        // Else, either left subtree or root
        // has the ceil value
        int ceil = Ceil(node.left, input);

        if (ceil != -1) {
            return ceil;
        } else {
            return node.key;
        }

    }

    public int floor(AVLNode root, int key) {
        if (root == null) {
            return -1;
        }

        /* If root->data is equal to key */
        if (root.key == key) {
            return root.key;
        }

        /* If root->data is greater than the key */
        if (root.key > key) {
            return floor(root.left, key);
        }

        /* Else, the floor may lie in right subtree
    or may be equal to the root*/
        int floorValue = floor(root.right, key);

        if (floorValue != -1) {
            return floorValue;
        } else {
            return root.key;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLTree<String> t = new AVLTree<String>();
        t.insert("A", 50);
        t.insert("B", 25);
        t.insert("C", 75);
        t.insert("D", 10);
        t.insert("E", 35);
        t.insert("F", 60);
        t.insert("G", 95);
        t.insert("H", 5);
        t.insert("I", 12);
        System.out.println(t.floor(t.root, 27));
        System.out.println(t.Ceil(t.root, 55));

    }
}
