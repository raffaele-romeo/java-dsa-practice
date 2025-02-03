package array;

import java.util.Arrays;

public class NumbersDifferFrom1Digit {
    public static int getUniqueNumbersThatDifferFrom1Digit(int[] numbers) {
        int output = 0;

        String[] stringArray = Arrays.stream(numbers).mapToObj(String::valueOf)
                .toArray(String[]::new);

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = i + 1; j < stringArray.length; j++) {
                if (differsByOneDigit(stringArray[i], stringArray[j])) {
                    output++;
                }
            }
        }

        return output;
    }

    private static boolean differsByOneDigit(String a, String b) {
        if (a.length() != b.length()) return false;
        int diffCount = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }

        return diffCount == 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 151, 241, 1, 9, 22, 351};
        System.out.println(getUniqueNumbersThatDifferFrom1Digit(arr)); // Output: 3
    }
}
