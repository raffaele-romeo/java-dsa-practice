package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    @Test
    public void twoSumTestTestCase1() {
        int[] inputTest = {3, 2, 4};
        int[] result = TwoSum.twoSum(inputTest, 6);

        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, result);
    }
}
