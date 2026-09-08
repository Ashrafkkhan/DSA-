class Solution {
    public void backtrack(String s,List<List<String>> res,List<String> curr,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
       
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (isPalindrome(sub)) {
                curr.add(sub);
                backtrack(s, res,curr,end);  
                curr.remove(curr.size() - 1);  
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        backtrack(s,res,new ArrayList<>(),0);
        return res;
    }
}
