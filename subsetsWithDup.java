class Solution {

    void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

       
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

           
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

           
            current.add(nums[i]);

         
            helper(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
}
