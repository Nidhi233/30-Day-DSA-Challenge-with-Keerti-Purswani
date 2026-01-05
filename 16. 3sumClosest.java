class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min_diff = Integer.MAX_VALUE;
        int closest_sum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            //to avoid duplicate arrays
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int j = i+1;
            int k = nums.length-1;
            //two pointer with i fixed
            while(j<k){
                int total = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target-total);
                
                if(diff<min_diff){
                    min_diff = diff;
                    closest_sum = total;
                }
                if(total<target){
                    j++;
                }
                else{
                    k--;
                }

            }
        }
        return closest_sum;
    }
}
