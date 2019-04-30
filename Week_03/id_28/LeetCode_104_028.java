class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } 
        int h1 = maxDepth(root.left);
        int h2 = maxDepth(root.right);
        return h1 > h2 ? h1+1 : h2+1;        
    }
}
