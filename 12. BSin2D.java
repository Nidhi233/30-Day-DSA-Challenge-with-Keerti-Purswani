class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search in 2D matrix
        int r = 0;
        int c = matrix[0].length-1;

        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target){
                return true;
            } else if(matrix[r][c]<target){
                r++;
            } else{
                c--;
            }
        }
        
        return false;
    }
}
