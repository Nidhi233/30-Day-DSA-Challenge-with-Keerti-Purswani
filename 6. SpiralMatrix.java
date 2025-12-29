class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;
        /*    T
            L---R
              B
        */
        while(top<=bottom && left<=right){
            // move right
            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            // move down
            for(int i=top; i<=bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            // move left
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // move up
            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
