class Solution {
    public int longestSubarray(int[] nums) {
        // slide window with atmost one zero
        int left = 0;
        int right = 0;
        int max_len = 0;
        int count_zero = 0;

        while(right<nums.length){
            if(nums[right]==0){
                count_zero++;
            }
            while(count_zero>1){
                if(nums[left]==0){
                    count_zero--;
                }
                left++;
            }
            max_len = Math.max(max_len, right-left+1);
            right++;
        }

        return max_len-1; // cause we will remove that 0
    }
}
