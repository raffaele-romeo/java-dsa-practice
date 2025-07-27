package binarytree;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeAlgorithms {
    public static List<Integer> dfs(TreeNode treeNode) {
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

    public static List<Integer> bfs(TreeNode treeNode) {
        var queue = new LinkedList<TreeNode>();
        var output = new ArrayList<Integer>();

        if (treeNode != null) {
            queue.offer(treeNode);
        }

        while (!queue.isEmpty()) {
            var current = queue.poll();
            output.add(current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return output;
    }

    public static List<Integer> preorderTraversal(TreeNode treeNode) {
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

    public static boolean treeIncludes(TreeNode root, int target) {
        var queue = new LinkedList<TreeNode>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            var currentElem = queue.poll();

            if (currentElem.val == target) {
                return true;
            }

            if (currentElem.left != null) {
                queue.offer(currentElem.left);
            }

            if (currentElem.right != null) {
                queue.offer(currentElem.right);
            }
        }

        return false;
    }

    public static boolean treeIncludesRecursive(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        return treeIncludesRecursive(root.left, target) || treeIncludesRecursive(root.right, target);
    }

    public static int sumTreeRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var leftSum = sumTreeRecursive(root.left);
        var rightSum = sumTreeRecursive(root.right);

        return root.val + leftSum + rightSum;
    }

    public static int treeMinRecursive(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        var leftMin = treeMinRecursive(root.left);
        var rightMin = treeMinRecursive(root.right);

        return Math.min(Math.min(leftMin, root.val), rightMin);
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.left == null && root.right == null) return root.val;

        var maxPathSumLeft = maxPathSum(root.left);
        var maxPathSumRight = maxPathSum(root.right);

        return root.val + Math.max(maxPathSumLeft, maxPathSumRight);
    }

    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) return 1;

        var maxPathSumLeft = maxDepthRecursive(root.left);
        var maxPathSumRight = maxDepthRecursive(root.right);

        return 1 + Math.max(maxPathSumLeft, maxPathSumRight);
    }

    class NodeDepthPair {
        TreeNode node;
        int depth;

        NodeDepthPair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        var result = 0;
        var queue = new Stack<NodeDepthPair>();

        if (root == null) {
            return result;
        }

        queue.push(new NodeDepthPair(root, 1));

        while (!queue.isEmpty()) {
            var elem = queue.pop();
            result = Math.max(result, elem.depth);

            if (elem.node.left != null) {
                queue.push(new NodeDepthPair(elem.node.left, elem.depth + 1));
            }

            if (elem.node.right != null) {
                queue.push(new NodeDepthPair(elem.node.right, elem.depth + 1));
            }
        }

        return result;
    }

    public int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level
            depth++; // We're processing a new level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Add children to queue for next level
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return depth;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

//        postorderTraversal(root).forEach(System.out::println);
//        System.out.println("\n");
//        inorderTraversal(root).forEach(System.out::println);
//        System.out.println("\n");
//        preorderTraversal(root).forEach(System.out::println);

        System.out.println(maxPathSum(root));
    }
}
