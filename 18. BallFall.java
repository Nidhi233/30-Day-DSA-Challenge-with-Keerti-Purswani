class Solution {
    public int[] findBall(int[][] grid) {
        // i,j --> (i+1, j+1) || (i+1, j-1)
        // right => (i, j+1) == 1 -> (i+1, j+1) else V
        // left => (i, j-1) == -1 -> (i+1, j-1) else V
        // also stuck if wall of:
        // left has -1 / OR right has 1 \
        ArrayList<Integer> ans = new ArrayList<>();
        int n = grid.length; // rows
        int m = grid[0].length; // cols

        for(int col=0; col<m; col++){ // for each col 
            // starts from row=0, col=i
            ans.add(dfs(grid, 0, col, n, m));
        }

        int[] res = new int[m];
        for(int i=0; i<m; i++){
            res[i] = ans.get(i);
        }

        return res;
    }

    private static int dfs(int[][] grid, int i, int j, int n, int m){
        if(i==n){
            return j;
        }

        if(j==0 && grid[i][j] == -1){ //left wall
            return -1;
        }
        if(j==m-1 && grid[i][j] == 1){ //right wall
            return -1;
        }


        if(grid[i][j]==1){ //right spans
            if(j+1<m && grid[i][j+1]==1){
                return dfs(grid, i+1, j+1, n, m);
            }
        } else if(grid[i][j]== -1){ //left spans
            if(j-1>=0 && grid[i][j-1]== -1){
                return dfs(grid, i+1, j-1, n, m);
            }
        }
        
        return -1;
    }
}
