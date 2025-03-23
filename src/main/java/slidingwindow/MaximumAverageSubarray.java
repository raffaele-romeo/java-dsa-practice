package slidingwindow;

class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        var maxSum = 0;
        var currentSum = 0;

        var n = nums.length;

        for (int i = 0; i < k; i++) {
            currentSum = currentSum + nums[i];
        }

        maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] input = {4,2,1,3,3};
        System.out.println(Solution.findMaxAverage(input, 2));
    }
}