import java.util.*;

public class BinaryTreeTraversal {

    static class Tree {
        int data;
        Tree left, right;

        Tree(int val) {
            this.data = val;
            left = right = null;
        }

    }

    private static void inOrder(Tree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static void preOrder(Tree root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Tree root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static void bfs(Tree root) {
        if (root == null)
            return;

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

}