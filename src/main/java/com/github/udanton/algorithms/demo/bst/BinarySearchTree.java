package com.github.udanton.algorithms.demo.bst;

public class BinarySearchTree {
    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        current.height = 1 + Math.max(height(current.left), height(current.right));

        int balance = balanceFactor(current);

        if (balance > 1 && value < current.left.value)
            return rotateRight(current);

        if (balance < -1 && value > current.right.value)
            return rotateLeft(current);

        if (balance > 1 && value > current.left.value) {
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }

        if (balance < -1 && value < current.right.value) {
            current.right = rotateRight(current.right);
            return rotateLeft(current);
        }

        return current;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
            ? containsRecursive(current.left, value)
            : containsRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
        } else {
            if (current.left == null || current.right == null) {
                Node temp = null;
                if (current.left == null)
                    temp = current.right;
                else
                    temp = current.left;

                if (temp == null) {
                    temp = current;
                    current = null;
                } else
                    current = temp;
            } else {
                Node temp = minValueNode(current.right);
                current.value = temp.value;
                current.right = deleteRecursive(current.right, temp.value);
            }
        }

        if (current == null) {
            return null;
        }

        current.height = Math.max(height(current.left), height(current.right)) + 1;

        int balance = balanceFactor(current);

        if (balance > 1 && balanceFactor(current.left) >= 0) {
            return rotateRight(current);
        }

        if (balance > 1 && balanceFactor(current.left) < 0) {
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }

        if (balance < -1 && balanceFactor(current.right) <= 0) {
            return rotateLeft(current);
        }

        if (balance < -1 && balanceFactor(current.right) > 0) {
            current.right = rotateRight(current.right);
            return rotateLeft(current);
        }

        return current;
    }

    private int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private Node rotateRight(Node node) {
        Node leftNode = node.left;
        Node rightNodeFromLeftNode = leftNode.right;

        leftNode.right = node;
        node.left = rightNodeFromLeftNode;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        leftNode.height = Math.max(height(leftNode.left), height(leftNode.right)) + 1;

        return leftNode;
    }

    private Node rotateLeft(Node node) {
        Node rightNode = node.right;
        Node leftNodeFromRightNode = rightNode.left;

        rightNode.left = node;
        node.right = leftNodeFromRightNode;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rightNode.height = Math.max(height(rightNode.left), height(rightNode.right)) + 1;

        return rightNode;
    }

}
