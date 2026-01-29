package com.paravar.learn.dsAlgo;

public class Q7BinaryTree {

    // Main method for testing
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Add elements to the tree
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        // Perform traversals
        tree.inOrderTraversal(); // *** // sorted order print
        tree.preOrderTraversal();
        tree.postOrderTraversal();


        // Search for elements in the tree
        System.out.println("Is 40 in the tree? " + tree.search(40)); // true
        System.out.println("Is 25 in the tree? " + tree.search(25)); // false
    }
}
// Node class to represent each node in the tree
class TreeNode {
    int value;          // Value of the node
    TreeNode left;      // Pointer to the left child
    TreeNode right;     // Pointer to the right child

    // Constructor
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// BinaryTree class to handle the tree operations
 class BinaryTree {
    TreeNode root; // Root of the binary tree

    // Constructor to initialize an empty tree
    public BinaryTree() {
        root = null;
    }

    // Method to add elements to the binary tree
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // Helper method to add elements recursively
    private TreeNode addRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = addRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = addRecursive(node.right, value);
        }
        return node; // Return unchanged node
    }

    // In-order traversal (Left -> Root -> Right)
    public void inOrderTraversal() {
        System.out.print("In-order: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode node) {
        // ****
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }

    // Pre-order traversal (Root -> Left -> Right)
    public void preOrderTraversal() {
        System.out.print("Pre-order: ");
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    // Post-order traversal (Left -> Right -> Root)
    public void postOrderTraversal() {
        System.out.print("Post-order: ");
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(TreeNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Method to search for a value in the binary tree
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // Helper method to search recursively
    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null) {
            return false; // Base case: not found
        }
        // pre-order
        if (node.value == value) {
            return true; // Value found
        }
        // Recursively search in the left or right subtree
        return value < node.value ? searchRecursive(node.left, value) : searchRecursive(node.right, value);
    }

}
