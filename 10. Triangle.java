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
