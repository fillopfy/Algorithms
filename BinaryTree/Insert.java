
public class Insert {

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
}