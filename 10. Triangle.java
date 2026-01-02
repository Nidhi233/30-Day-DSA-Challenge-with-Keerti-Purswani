// BOTTOM-UP
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // picture bottom right-angled triangle on left side
        // start processing from n-2 row and go to the top
        // i,j and i,j+1 leads to i-1,j
        // try this in-place i.e edit the given trian itself w min sum path

        int n = triangle.size(); // no of rows
        // no of cols in ith row = i+1 (i goes till <n)
        // last second row is i=n-2
        for(int i=n-2; i>=0; i--){
            // traverse through col for this row
            for(int j=0; j<triangle.get(i).size(); j++){
                int below = triangle.get(i+1).get(j);
                int right_below = triangle.get(i+1).get(j+1);
                int min_val = Math.min(below, right_below) + triangle.get(i).get(j);
                triangle.get(i).set(j, min_val);
            }
        }
        return triangle.get(0).get(0);
    }
}

// RECURSION+DP
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // ro1 => i, row2 => i or i+1
        int n = triangle.size(); // rows
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> ls = new ArrayList<>();
            for(int j=0; j<i+1; j++){
                ls.add(Integer.MAX_VALUE);
            }
            dp.add(ls);
        }
        System.out.println(dp);
        int sum = 0;
        sum = helper(triangle, 0, 0, n, dp);
        return sum;

    }

    private int helper(List<List<Integer>> triangle, int i, int j, int n, List<List<Integer>> dp){
        if(i==n-1){
            return triangle.get(i).get(j);
        }

        if(dp.get(i).get(j) != Integer.MAX_VALUE){
            return dp.get(i).get(j);
        }
        //sum = triangle.get(i).get(j);
        
        // curr: row = i, col = j
        // next: row = i+1, col = j or j+1
        int sum1 = helper(triangle, i+1, j, n, dp);

        int sum2 = helper(triangle, i+1, j+1, n, dp);

        int min_sum = triangle.get(i).get(j) + Math.min(sum1, sum2);
        dp.get(i).set(j, min_sum);
        return min_sum;
    }
}
