
class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length -1;
        int maxarea=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int l=right - left;
            maxarea=Math.max(maxarea, h * l);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;

        }
    }
