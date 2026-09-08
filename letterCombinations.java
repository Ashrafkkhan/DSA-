class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        helper("", digits, map, ans);
        return ans;
    }

    void helper(String p, String digits, String[] map, List<String> ans) {
        if (digits.isEmpty()) {
            ans.add(p);
            return;
        }

        int digit = digits.charAt(0) - '0';
        String letters = map[digit];

        for (char ch : letters.toCharArray()) {
            helper(p + ch, digits.substring(1), map, ans);
        }
    }
}
