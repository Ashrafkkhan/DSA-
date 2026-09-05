class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int m=0;
        for(int i=0;i<n;i++){
            if(i==0|| nums[i]!=nums[i-1]){
                nums[m++]=nums[i];
            }
        }
        int left = 0;
        int maxKeep = 0;

        // Sliding window
        for (int right = 0; right < m; right++) {

            while (nums[right] - nums[left] >= n) {
                left++;
            }

            maxKeep = Math.max(maxKeep, right - left + 1);
        }

        return n - maxKeep;
        
    }
}
