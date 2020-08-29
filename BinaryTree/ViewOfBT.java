import java.util.*;

public class ViewOfBT {

    // Left View of Binary tree
    private static void leftView(Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> q = new LinkedList<Tree>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Tree node = q.peek();

            if (node != null) {
                System.out.print(node.data + " ");

                while (node != null) {
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }

                    q.poll();
                    node = q.peek();
                }

                q.add(null);

            }
            q.poll();
        }

    }

    // Right View of Binary tree
    private static void rightView(Tree root) {
        if (root == null) {
            return;
        }

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Tree node = q.peek();
            if (node != null) {
                while (node != null) {
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                    Tree last = q.poll();
                    node = q.peek();

                    // print last node data because it is in right view of binary tree
                    if (node == null) {
                        System.out.print(last.data + " ");
                    }
                }
                q.add(null);
            }
            q.poll();
        }
    }


    //Top View of Binary tree

    private static void topView(Tree root){
        if(root==null){
            return;
        }
        
    }

}