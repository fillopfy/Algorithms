
import java.util.*;

public class LCA {

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
        return path1.get(i - 1);
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

}