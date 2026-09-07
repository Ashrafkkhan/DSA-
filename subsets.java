class Solution {

    public void helper(int[] nums, List<List<Integer>> res, int i, List<Integer> current) {
        if (i == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        helper(nums, res, i + 1, current);

        current.remove(current.size() - 1);
        helper(nums, res, i + 1, current);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0, new ArrayList<>());
        return res;
    }
}
