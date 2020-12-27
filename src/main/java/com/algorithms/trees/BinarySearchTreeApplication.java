package com.algorithms.trees;

public class BinarySearchTreeApplication {
    private int ans;

    BinarySearchTreeApplication() {
        ans = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        BinarySearchTreeApplication tree = new BinarySearchTreeApplication();
        TreeNode root = tree.insertBinarySearchTree(null, 21);
        root = tree.insertBinarySearchTree(root, 18);
        root = tree.insertBinarySearchTree(root, 28);
        root = tree.insertBinarySearchTree(root, 12);
        root = tree.insertBinarySearchTree(root, 19);
        root = tree.insertBinarySearchTree(root, 20);
        root = tree.insertBinarySearchTree(root, 32);
        root = tree.insertBinarySearchTree(root, 22);
        root = tree.insertBinarySearchTree(root, 27);
        //tree.inOrderTraversal(root);
        tree.findFloor(root, 28);
        System.out.println(tree.ans);
    }
    /*
     * floor : largest number less than equal to x
     * Initialize ans with Integer.MIN_VALUE.
     * T.C : O(N)
     */
    public void findFloor(final TreeNode root, int x) {
        if (root == null) {
            return;
        }
        if(root.data <= x) {
            ans = Math.max(ans, root.data);
        }
        findFloor(root.left, x);

        findFloor(root.right, x);
    }

    /*
     * ceil : Smallest number greater than equal to x
     * Initialize ans with Integer.MAX_VALUE.
     * T.C : O(N)
     */

    public void findCeil(final TreeNode root, int x) {
        if (root == null) {
            return;
        }
        if(root.data >= x) {
            ans = Math.min(ans,root.data);
        }
        findFloor(root.left, x);

        findFloor(root.right, x);
    }

    public void inOrderTraversal(final TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    /*
     * Check if the tree is binary search tree. TC : O(N)
     */
    public boolean isBstInorder(final TreeNode root, int prev) {
        if (root == null) {
            return true;
        }
        if (!isBstInorder(root.left, prev)) {
            return false;
        }

        if (prev > root.data) {
            return false;
        }
        return isBstInorder(root.right, root.data);

    }

    /*
     * Check if the tree is binary search tree.
     */
    public boolean isBst(final TreeNode root, final int min, final int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
    }

    /*
     * Search in binary search tree returns boolean.
     */
    public boolean searchInBinarySearchTree(final TreeNode root, final int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        if (x < root.data) {
            return searchInBinarySearchTree(root.left, x);
        } else {
            return searchInBinarySearchTree(root.right, x);
        }
    }

    public int findMin(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    /*
     * Delete node in Binary search tree. if node.data == key three cases arise. 1) Leaf node 2) single Child Node 3) two Child Node 1) find minimum
     * in right subtree replace and delete the minimum in right subtree. or 2) find maximum in left subtree replace and delete the maximum in left
     * subtree.
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int min = findMin(root.right);
                root.data = min;
                root.right = deleteNode(root.right, min);
            }
        }
        return root;
    }

    /*
     * Recursive insert in binary search tree. TC : Height of tree w.c O(N) best case O(log n)
     */
    public TreeNode insertBinarySearchTreeRecursive(final TreeNode root, final int x) {
        if (root == null) {
            return new TreeNode(x);
        }
        if (root.data < x) {
            root.right = insertBinarySearchTreeRecursive(root.right, x);
        } else {
            root.left = insertBinarySearchTreeRecursive(root.left, x);
        }
        return root;
    }

    /*
     * Iterative insert in binary search tree.Need an extra pointer previous.
     */

    public TreeNode insertBinarySearchTree(final TreeNode root, final int x) {
        TreeNode prev = null;
        TreeNode current = root;
        TreeNode nw = new TreeNode(x);
        if (root == null) {
            return nw;
        }
        while (current != null) {
            if (current.data < x) {
                prev = current;
                current = current.right;
            } else {
                prev = current;
                current = current.left;
            }
        }
        if (prev.data < x) {
            prev.right = nw;
        } else {
            prev.left = nw;
        }
        return root;
    }
}
