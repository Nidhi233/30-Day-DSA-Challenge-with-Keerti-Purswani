class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // store first row and col ka data
        boolean firstRow = false;
        boolean firstCol = false;

        for(int col=0; col<m; col++){
            if(matrix[0][col]==0){
                firstRow = true;
            }
        }
        for(int row=0; row<n; row++){
            if(matrix[row][0]==0){
                firstCol = true;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        // traverse through and mark 0 
        // firstRow => i=0, firstCol => j=0

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRow==true){
            for(int col=0; col<m; col++){
                matrix[0][col] = 0;
            }
        }
        if(firstCol==true){
            for(int row=0; row<n; row++){
                matrix[row][0]=0;
            }
        }

        return;
    }
}
