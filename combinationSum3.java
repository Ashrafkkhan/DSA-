class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        if(k>n){
            return res;
        }
        backtrack(k,n,new ArrayList(),res,1);
        return res;
    }
    public void backtrack(int k,int n,List<Integer> curr,List<List<Integer>> res,int i){
        if(curr.size()==k ){
            if (n == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
         if (i > 9 || n < 0) {
            return;
        }
        curr.add(i);
        backtrack(k, n - i, curr, res, i + 1);
        curr.remove(curr.size() - 1);
        backtrack(k, n, curr, res, i + 1);
    }
}
