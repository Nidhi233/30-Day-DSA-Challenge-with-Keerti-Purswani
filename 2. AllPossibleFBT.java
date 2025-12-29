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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0){
            return new ArrayList<>();
        }

        List<TreeNode>[] dp = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = new ArrayList<>();
        }

        dp[1].add(new TreeNode(0));
        for(int i=3; i<=n; i=i+2){
            for(int left=1; left<i; left=left+2){
                int right = i-1-left;
                for(TreeNode l: dp[left]){
                    for(TreeNode r: dp[right]){
                        TreeNode root = new TreeNode(0, l, r);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];
    }
}

// RECURSION + MEMOIZATION
// class Solution {
//     public List<TreeNode> allPossibleFBT(int n) {
//         if(n%2==0){
//             return new ArrayList<TreeNode>();
//         }

//         List<TreeNode> res = new ArrayList<>();
//         HashMap<Integer, List<TreeNode>> mpp = new HashMap<>();
        
//         res = helper(n, mpp);
//         return res;
//     }

//     private List<TreeNode> helper(int n, HashMap<Integer, List<TreeNode>> mpp){
//         if(mpp.containsKey(n)){
//             return mpp.get(n);
//         }

//         List<TreeNode> res = new ArrayList<>();
    
//         if(n==1){
//             res.add(new TreeNode(0));
//             mpp.put(n, res);
//             return res;
//         }
        
//         // split n-1 into l and r
//         for(int i=1; i<n; i+=2){
//             List<TreeNode> left = helper(i, mpp);
//             List<TreeNode> right = helper(n-1-i, mpp);

//             for(TreeNode l: left){
//                 for(TreeNode r: right){
//                     TreeNode root = new TreeNode(0,l,r);
//                     res.add(root);
//                 }
//             }
//         }
//         mpp.put(n, res);
//         return res;
//     }
// }
