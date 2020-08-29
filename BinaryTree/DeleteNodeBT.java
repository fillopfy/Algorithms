import java.util.*;

public class DeleteNodeBT {
    // delete given node
    private static Tree delete(Tree root, int val) {
        if (root == null)
            return root;
        Tree node = null, temp = null;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.data == val) {
                temp = node;
            }
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }

        int k = node.data;
        deleteDeepest(root, node);
        temp.data = k;

        return root;

    }

    private static void deleteDeepest(Tree root, Tree node) {
        if (root == null)
            return;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree temp = q.poll();
            if (temp.right != null) {
                if (temp.right == node) {
                    temp.right = null;
                    node = null;
                    return;
                } else {
                    q.add(temp.right);
                }

                if (temp.left != null) {
                    if (temp.left == node) {
                        temp.left = null;
                        node = null;
                        return;

                    } else {
                        q.add(temp.left);
                    }
                }
            }
        }
    }
}