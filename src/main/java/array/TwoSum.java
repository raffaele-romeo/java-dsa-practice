package array;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int j;
        int[] result = new int[2];

        for (int i = 0; i <= nums.length - 2; i++) {
            j = nums.length - 1;
            while (j > i) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                }
                j--;
            }
        }

        return result;
    }
}
