// BOTTOM UP
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];
        dp[n-1][m-1] = Math.max(1, 1-dungeon[n-1][m-1]);

        // fill last row
       for(int col=m-2; col>=0; col--){
            dp[n-1][col] = Math.max(1, dp[n-1][col+1]-dungeon[n-1][col]);
        }

        // fill last col
        for(int row=n-2; row>=0; row--){
            dp[row][m-1] = Math.max(1, dp[row+1][m-1] - dungeon[row][m-1]);
        }

        // fill rest
        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                int minRD = Math.min(dp[i+1][j] , dp[i][j+1]);
                dp[i][j] = Math.max(1, minRD-dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}

// DP - TOP DOWN
// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         // lets go from 0,0 to n-1, m-1
//         int n = dungeon.length;
//         int m = dungeon[0].length;
//         int[][] dp = new int[n][m];
//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 dp[i][j] = -1;
//             }
//         }

//         int h = helper(dungeon, 0, 0, n, m, dp);
//         return h;
//     }

//     private static int helper(int[][] dungeon, int i, int j, int n, int m, int[][] dp){
//         if(i>=n || j>=m){
//             return Integer.MAX_VALUE;
//         }
//         if(i==n-1 && j==m-1){
//             dp[i][j] = Math.max(1, 1-dungeon[i][j]);
//             return dp[i][j];
//         }

//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         // i,j -> (i, j+1) RIGHT, (i+1, j) DOWN
//         int right = helper(dungeon, i, j+1, n, m, dp);
//         int down = helper(dungeon, i+1, j, n, m, dp);
//         int min = Math.min(right, down);
//         if(min==Integer.MAX_VALUE){
//             return min;
//         }
//         int need =  min - dungeon[i][j];

//         dp[i][j] = Math.max(1, need);
//         return dp[i][j];
//     }
// }

// RECURSION
// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         // lets go from 0,0 to n-1, m-1
//         int n = dungeon.length;
//         int m = dungeon[0].length;

//         int h = helper(dungeon, 0, 0, n, m);
//         return h;
//     }

//     private static int helper(int[][] dungeon, int i, int j, int n, int m){
//         if(i>=n || j>=m){
//             return Integer.MAX_VALUE;
//         }
//         if(i==n-1 && j==m-1){
//             return Math.max(1, 1-dungeon[i][j]);
//         }

//         // i,j -> (i, j+1) RIGHT, (i+1, j) DOWN
//         int right = helper(dungeon, i, j+1, n, m);
//         int down = helper(dungeon, i+1, j, n, m);
//         int min = Math.min(right, down);
//         if(min==Integer.MAX_VALUE){
//             return min;
//         }
//         int need =  min - dungeon[i][j];

//         int health = Math.max(1, need);
//         return health;
//     }
// }
