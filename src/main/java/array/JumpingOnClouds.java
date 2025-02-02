package array;

import java.util.List;

public class JumpingOnClouds {
    public static int jumpingOnClouds(List<Integer> clouds) {
        int currentCloud = 0;
        int totalJumps = 0;

        while (currentCloud < clouds.size() - 1) {
            // Prefer a 2-cloud jump if possible
            if (currentCloud + 2 < clouds.size() && clouds.get(currentCloud + 2) == 0) {
                currentCloud += 2;
            } else {
                currentCloud += 1;
            }
            totalJumps++;
        }

        return totalJumps;
    }
}
