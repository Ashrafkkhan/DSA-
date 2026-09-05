class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i+k-1<nums.length;i++){
            min=Math.min(min,nums[i+k-1]-nums[i]);
        }return min;
        
    }
}
