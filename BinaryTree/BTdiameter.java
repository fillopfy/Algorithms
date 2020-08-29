
public class BTdiameter {
    // Diameter of Binary Tree
    // Diameter=max(lDiameter, rDiameter, 1+lHeight+rHeight)
    // O(n^2)

    private static int diameterOfBT(Tree root) {
        if (root == null)
            return 0;
        return diameter(root);
    }

    private static int diameter(Tree root) {
        if (root == null) {
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));

    }

    private static int height(Tree root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}