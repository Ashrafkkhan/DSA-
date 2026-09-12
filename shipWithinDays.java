class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int w:weights){
            left=Math.max(left,w);
            right+=w;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(weights,days,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean isPossible(int[] weights, int days,int capacity){
        int daysUsed = 1;
        int currWeight = 0;
        for (int w : weights) {
            if (currWeight + w > capacity) {
                daysUsed++;
                currWeight = w;

                if (daysUsed > days) {
                    return false;
                }
            } else {
                currWeight += w;
            }
        }

        return true;
    }
}
