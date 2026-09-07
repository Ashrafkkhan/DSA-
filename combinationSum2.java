class Solution {
    public void backtrack(int[]nums,int index,int t,List<List<Integer>> res,List<Integer> current){
        if(t==0){
            res.add(new ArrayList<>(current));
            return;
        }
        if(t<0){
            return ;
        }
        for(int i=index;i<nums.length;i++){
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
               if (nums[i] > t) {
                break;
            }
            current.add(nums[i]);
            backtrack(nums,i+1,t-nums[i],res,current);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
         Arrays.sort(candidates);
        backtrack(candidates,0, target, result,new ArrayList<>());
        return result; 
        
    }
}
