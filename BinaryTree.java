import java.util.*;

public class BinaryTree {

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

    private static bfs(Tree root){
        if(root==null) return;

        Queue<Tree> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Tree node=q.poll();
            System.out.print(node.data+" ");
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }

    private static boolean isPresent(Tree root, int val) {
        if (root == null)
            return false;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree node = q.poll();
            if (node.data == val)
                return true;
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return false;
    }

    // insertig a node
    private static Tree insert(Tree root, int val) {
        if (root == null) {
            return new Tree(val);
        }
        Tree newNode = new Tree(val);
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree node = q.poll();
            if (node.left == null) {
                node.left = newNode;
                break;
            } else if (node.right == null) {
                node.right = newNode;
                break;
            }

            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }

        return root;

    }

    // delete gievn node
    private static Tree delete(Tree root, int val) {
        if (root == null)
            return root;
        Tree node = null, temp = null;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree node = q.poll();
            if (node.data == val) {
                temp = node;
            }
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }

        int k = node.data;
        temp.data = k;
        node.data = k;
        deleteDeepest(root, node);

        return root;

    }

    private static Tree deleteDeepest(Tree root, Tree node) {
        if (root == null)
            return root;
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

    // findpath of given node and store in list, return false if no path found
    private static boolean findPath(Tree root, int k, List<Integer> path) {

        // base case
        if (root == null)
            return false;

        // add to path
        path.add(root.data);

        // check if it the same node
        if (root.data == k) {
            return true;
        }

        // go left and check again
        if (root.left != null && findPath(root.left, k, path)) {
            return true;
        }

        // go right and check again
        if (root.right != null && findPath(root.right, k, path)) {
            return true;
        }

        // if not rooted with root subtree, remove it
        path.remove(path.size() - 1);
        return false;

    }

    // lowest common ancestor for two given nodes
    private static int lca(Tree root, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println("No path exists");
            return -1;
        }
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get((i))) {
                break;
            }
        }
        return path.get(i - 1);
    }

}