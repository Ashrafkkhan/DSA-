class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total=0;
        for(int n : arr){
            total+=n;
        }
        if(total%3!=0){
            return false;
        }
        int target=total/3;
        int part=0;
        int sum=0;
        for(int n:arr){
            sum+=n;
            if(sum==target){
                part++;
                sum=0;
            }
        }
        return part>=3;
    }
}
