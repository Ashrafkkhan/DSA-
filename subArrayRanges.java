class Solution {
     /* Brute force
     public long max(int arr[],int s,int e){
        
        long max=Long.MIN_VALUE;
        for(int i=s;i<=e;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }return max;
    }
    public long min(int arr[],int s,int e){
        long min = Long.MAX_VALUE;
        for(int i=s;i<=e;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }return min;
    }*/
    public int[] nse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
      
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] pse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nle(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] ple(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public long subArrayRanges(int[] nums) {
        long count=0;
        /*for(int i=0;i<nums.length;i++){
            count+=max(nums,i,i)-min(nums,i,i);
            for(int j=i+1;j<nums.length;j++){
                count+=max(nums,i,j)-min(nums,i,j);
            }
        }return count;*/
        int n = nums.length;
        int[] pl = ple(nums);
        int[] nl = nle(nums);
        int[] ps = pse(nums);
        int[] ns = nse(nums);

        long minTotal = 0;
        long maxTotal = 0;

        for (int i = 0; i < n; i++) {
            long leftMin = i - ps[i];
            long rightMin = ns[i] - i;
            minTotal += leftMin * rightMin * nums[i];

            long leftMax = i - pl[i];
            long rightMax = nl[i] - i;
            maxTotal += leftMax * rightMax * nums[i];
        }

        return maxTotal - minTotal;
        
    }
}
