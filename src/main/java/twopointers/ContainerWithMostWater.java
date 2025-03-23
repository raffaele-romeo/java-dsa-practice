package twopointers;

class Solution {
    public static int maxArea(int[] height) {
        var maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, minHeight * (j - i));

            // Move the pointer at the shorter height
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(Solution.maxArea(input));
    }
}
