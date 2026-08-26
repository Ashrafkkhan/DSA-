class Solution {
    public int candy(int[] ratings) {
        int ldist[]=new int[ratings.length];
        int rdist[]=new int[ratings.length];
        ldist[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                ldist[i]=ldist[i-1]+1;
            }else{
                ldist[i]=1;
            }
        }int n=ratings.length;
        rdist[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rdist[i]=rdist[i+1]+1;
            }else{
                rdist[i]=1;
            }
        }
        int cand=0;
        for(int i=0;i<n;i++){
            cand+=Math.max(ldist[i],rdist[i]);
        }return cand;
        
    }
}
