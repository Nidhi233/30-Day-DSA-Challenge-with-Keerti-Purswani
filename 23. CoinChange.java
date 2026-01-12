// BOTTOM-UP
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // min coins to make amt for dp[amt]

        for(int i=0; i<dp.length; i++){
            dp[i] = amount+1;
        }

        dp[0] = 0;
        for(int c: coins){
            int curr = c;
            while(curr<=amount){
                dp[curr] = Math.min(1+dp[curr-c], dp[curr]);
                curr++;
            }
        }
        
        if(dp[amount]>amount){
            return -1;
        }

        return dp[amount];
    }
}

// TOP-DOWN DP
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         // overlapping subproblems of ind and sum
//         int[][] dp = new int[coins.length][amount+1];
//         for(int i=0; i<dp.length; i++){
//             for(int j=0; j<dp[0].length; j++){
//                 dp[i][j] = -2;
//             }
//         }
//         int count = helper(coins, amount, 0, dp);
        
//         if(count==Integer.MAX_VALUE-1){
//             return -1;
//         }

//         return count;
//     }

//     private static int helper(int[] arr, int sum, int ind, int[][] dp){
//         if(sum==0){
//             return 0;
//         }
//         if(sum<0 || ind>=arr.length){
//             return Integer.MAX_VALUE-1;
//         }

//         if(dp[ind][sum] != -2){
//             return dp[ind][sum];
//         }

//         // dont pick
//         int res = helper(arr, sum, ind+1, dp);

//         // pick
//         if(arr[ind]<=sum){
//             res = Math.min(1 + helper(arr, sum-arr[ind], ind, dp), res);
//         }

//         dp[ind][sum] = res;
//         return res;
//     }
// }

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int count = helper(coins, amount, 0);
//         return (count == Integer.MAX_VALUE - 1) ? -1 : count;
//     }

//     private int helper(int[] arr, int sum, int ind){
//         if(sum==0){
//             return 0;
//         }
//         if(sum<0 || ind>=arr.length){
//             return Integer.MAX_VALUE - 1 ;// not possible so wont get picked in min
//         }
//         //dont pick
//         //int dontpick = helper(arr, sum, ind+1);
//         int res = helper(arr, sum, ind+1);

//         //pick
//         if(arr[ind]<=sum){
//             res = Math.min(1 + helper(arr, sum-arr[ind], ind), res);
//         } 
    

//         return res;
//     }
// }
