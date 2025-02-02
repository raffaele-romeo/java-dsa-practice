package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JumpingOnCloudsTest {

    @Test
    public void jumpingOnCloudsTestCase1() {
        List<Integer> inputTest = List.of(0, 0, 0, 1, 0, 0);
        int result = JumpingOnClouds.jumpingOnClouds(inputTest);

        Assertions.assertEquals(result, 3);
    }
}
