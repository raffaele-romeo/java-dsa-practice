package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeAlgorithms {
    public static List<Integer> dfs (TreeNode treeNode) {
        var stack = new Stack<TreeNode>();
        var output = new ArrayList<Integer>();

        if (treeNode != null) {
            stack.push(treeNode);
        }

        while (!stack.isEmpty()) {
            var current = stack.pop();
            output.add(current.val);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return output;
    }

    public static List<Integer> preorderTraversal (TreeNode treeNode) {
        var output = new ArrayList<Integer>();

        if (treeNode != null) {
            output.add(treeNode.val);
            output.addAll(preorderTraversal(treeNode.left));
            output.addAll(preorderTraversal(treeNode.right));
        }

        return output;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        var output = new ArrayList<Integer>();

        if (root != null) {
            output.addAll(inorderTraversal(root.left));
            output.add(root.val);
            output.addAll(inorderTraversal(root.right));
        }

        return output;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        var output = new ArrayList<Integer>();

        if (root != null) {
            output.addAll(postorderTraversal(root.left));
            output.addAll(postorderTraversal(root.right));
            output.add(root.val);
        }

        return output;
    }


    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        postorderTraversal(root).forEach(System.out::println);
        System.out.println("\n");
        inorderTraversal(root).forEach(System.out::println);
        System.out.println("\n");
        preorderTraversal(root).forEach(System.out::println);
    }
}
