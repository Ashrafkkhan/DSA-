class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

   
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        if (i == sb.length()) { 
            return "0"; 
        }
        return sb.substring(i);
    }
}
