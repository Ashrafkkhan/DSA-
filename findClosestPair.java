import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = arr1.length;
        int m = arr2.length;

        int i = 0;          
        int j = m - 1;      

        int minDiff = Integer.MAX_VALUE;
        int bestA = -1, bestB = -1;

        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);

            if (diff < minDiff) {
                minDiff = diff;
                bestA = arr1[i];
                bestB = arr2[j];
            }

            if (sum > x) {
                j--; 
                
            } else if (sum < x) {
                i++; 
                
            } else {
          
                break;
            }
        }

        res.add(bestA);
        res.add(bestB);
        return res;
    }
}
