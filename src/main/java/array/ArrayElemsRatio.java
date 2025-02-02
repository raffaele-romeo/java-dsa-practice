package array;

import java.util.List;

public class ArrayElemsRatio {
    public static void plusMinus(List<Integer> arr) {
        int arrSize = arr.size();
        double positiveRatio = 0;
        double negativeRatio = 0;
        double zeroRatio = 0;

        for (int value : arr) {
            if (value > 0) {
                positiveRatio++;
            }

            if (value < 0) {
                negativeRatio++;
            }

            if (value == 0) {
                zeroRatio++;
            }
        }

        System.out.println(String.format("%.6f", positiveRatio / arrSize));
        System.out.println(String.format("%.6f", negativeRatio / arrSize));
        System.out.println(String.format("%.6f", zeroRatio / arrSize));
    }
}

