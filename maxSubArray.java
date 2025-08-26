class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum =nums[0],curr=nums[0];
       
        for (int start = 1; start < nums.length; start++) {
          curr=Math.max(nums[start],nums[start]+curr);
          max_sum=Math.max(curr,max_sum);}
        return max_sum;
    }
}
