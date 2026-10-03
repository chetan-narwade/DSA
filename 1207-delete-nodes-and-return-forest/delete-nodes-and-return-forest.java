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
    public List<TreeNode> delNodes(TreeNode root, int[] nums) {
        List<TreeNode> ans = new ArrayList();
        Set<Integer> map = new HashSet<>();
        for (int val : nums) {
            map.add(val);
        }
        if(!map.contains(root.val)){
            ans.add(root);
        }
        f(root,ans,map);
        return ans;
    }public static TreeNode f(TreeNode root, List<TreeNode> ans,Set<Integer> map ){
        if(root==null) return null;

        root.left = f(root.left,ans,map);
        root.right = f(root.right,ans,map);
         if (map.contains(root.val)) {
            if (root.left != null)
                 ans.add(root.left);
             if (root.right != null)
                ans.add(root.right);
                return null;
         }
         return root;
    }
}