class Solution {
    public void rotate(int[][] matrix) {
        // transpose and reverse
        int n = matrix.length;

        for(int i=0; i<n; i++){ // upper triangle
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){
            // row-wise reversing
            int a = 0;
            int b = n-1;
            while(a<=b){
                // swap
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
                a++;
                b--;
            }
        }

        return;
    }
}
