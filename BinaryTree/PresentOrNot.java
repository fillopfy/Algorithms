
public class PresentOrNot {
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
}