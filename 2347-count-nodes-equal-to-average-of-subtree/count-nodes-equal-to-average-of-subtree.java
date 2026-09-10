/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;

    }

    public int[] solve(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };

        int left[] = solve(root.left);
        int right[] = solve(root.right);

        int sum = root.val + left[0] + right[0];
        int node = 1 + left[1] + right[1];

        int avg = sum / node;

        res += avg == root.val ? 1 : 0;

        return new int[] { sum, node };
    }
}