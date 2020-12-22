package com.algorithms.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeApplication {
    TreeNode head;

    public static void main(String[] args) {
        BinaryTreeApplication tree = new BinaryTreeApplication();
        tree.head = new TreeNode(1);
        tree.head.left = new TreeNode(2);
        tree.head.right = new TreeNode(3);
        tree.head.left.left = new TreeNode(4);
        tree.head.left.left.left = new TreeNode(6);
        tree.head.left.right = new TreeNode(5);
        tree.head.right.left = new TreeNode(8);
        tree.head.right.right = new TreeNode(9);
        tree.head.right.right.right = new TreeNode(10);
        TreeNode temp = tree.head;
        //tree.binaryTreeToItsMirror(temp);
        tree.printLevelOrderWithDepth(temp);
        //System.out.println("done");

    }

    /*
     * T.C = O(N) number of nodes
     */
    public int getTotalNode(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + getTotalNode(root.left) + getTotalNode(root.right);
    }

    /*
     * T.C = O(N) number of nodes
     * height of tree is height of longest path from root to leaf node.
     */
    public int heightOfTree(final TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    /*
     * T.C = O(N) number of nodes
     */ 
    public int sumOfAllNodesOfTree(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.data + sumOfAllNodesOfTree(root.left) + sumOfAllNodesOfTree(root.right);
    }

    /*
     * T.C = O(N) number of nodes
     */
    public int findMax(final TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }

    /*
     Depth: length of longest path from root to the given node.
     */

    public void fillDepth(final TreeNode root, int d) {
        if (root == null) {
            return;
        }

        root.depth = d;
        fillDepth(root.left, d + 1);
        fillDepth(root.right, d + 1);

    }

    /*
     * T.C = O(N) number of nodes
     */
    public void preOrderTraversal(final TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /*
     * T.C = O(N) number of nodes
     */
    public void inOrderTraversal(final TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    /*
     * T.C = O(N) number of nodes
     */
    public void postOrderTraversal(final TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    /*
     Print Binary Tree in level Order using Queue: TC: O(N)
     */
    public void printLevelOrder(final TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }
        while (!queue.isEmpty()) {
            TreeNode td = queue.poll();
            if (td == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                } else {
                    break;
                }

            } else {
                System.out.print(td.data + " ");
                if (td.left != null) {
                    queue.add(td.left);
                }
                if (td.right != null) {
                    queue.add(td.right);
                }
            }

        }
    }

    public int getNumberOfDigit(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
    /*
     Sum of all the numbers formed along all the path from root to leaf.
     */
    public double solve(final TreeNode root, double val) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return val;
        }
        val = val * Math.pow(10, getNumberOfDigit(root.data)) + root.data;
        return solve(root.left, val) + solve(root.right, val);
    }

    public void fillDepthMap(final TreeNode root, int d, Map<Integer, List<Integer>> mp) {
        if (root == null) {
            return;
        }
        List<Integer> li;
        if (mp.containsKey(d)) {
            li = mp.get(d);
        } else {
            li = new ArrayList<Integer>();
        }
        li.add(root.data);
        mp.put(d, li);
        fillDepthMap(root.left, d + 1, mp);
        fillDepthMap(root.right, d + 1, mp);

    }

    public void printLevelOrderWithDepth(final TreeNode root) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        //prepare map of each depth and list of nodes in that depth.
        fillDepthMap(root, 0, mp);
        //get the height of tree that is height of root.
        int height = heightOfTree(root);
        for (int i = 0; i <= height; i++) {
            List<Integer> li = mp.get(i);
            for (Integer data : li) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }


    /*
     * preOrder traversal using stack T.C = O(N) number of nodes Space Complexity O(h) : h height of stack (any time maximum nodes on stack will be
     * equal to height)
     */
    public List<Integer> iterativePreOderTraversal(final TreeNode root) {
        final Stack<TreeNode> st = new Stack<>();
        final List<Integer> list = new ArrayList<>();
        if (root != null) {
            st.push(root);
        }
        while (!st.isEmpty()) {
            TreeNode td = st.pop();
            System.out.print(td.data + " ");
            list.add(td.data);
            if (td.left != null) {
                st.add(td.left);
            }
            if (td.right != null) {
                st.add(td.right);
            }
        }
        return list;
    }

    /*
     * Iterative in-order Traversal : T.C O(N) number of nodes Space Complexity O(h) : h height of stack (any time maximum nodes on stack will be
     * equal to height)
     */
    public List<Integer> iterativeInorderTraversal(final TreeNode root) {
        final Stack<TreeNode> st = new Stack<>();
        final List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                st.add(current);
                current = current.left;
            }
            if (st.isEmpty()) {
                break;
            }
            current = st.pop();
            System.out.print(current.data + " ");
            list.add(current.data);
            current = current.right;
        }
        return list;
    }

    /*
     * Iterative post-order traversal : T.C O(N) number of nodes. Space Complexity O(n) approx h+n
     */
    public List<Integer> iterativePostOrderTraversal(final TreeNode root) {
        final Stack<TreeNode> st1 = new Stack<>();
        final Stack<Integer> st2 = new Stack<>();
        final List<Integer> list = new ArrayList<>();
        if (root != null) {
            st1.add(root);
        }
        while (!st1.isEmpty()) {
            TreeNode td = st1.pop();
            st2.push(td.data);
            if (td.left != null) {
                st1.push(td.left);
            }
            if (td.right != null) {
                st1.push(td.right);
            }
        }
        while (!st2.isEmpty()) {
            list.add(st2.pop());
        }
        return list;
    }

    /*
      L(swap left subtree),R(swap right subtree),D(swap left and right of node).
      DLR,DRL,RLD,LRD,LDL,RDR will all work but LDR or RDL will not work.
     */

    public void binaryTreeToItsMirror(TreeNode root) {
          if(root == null) {
              return;
          }
          TreeNode temp = root.left;
          root.left = root.right;
          root.right = temp;
         binaryTreeToItsMirror(root.left);
         binaryTreeToItsMirror(root.right);
    }
}
