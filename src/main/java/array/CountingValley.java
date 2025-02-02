package array;

public class CountingValley {
    public static int countingValleys(int steps, String path) {
        char[] pathArray = path.toCharArray();
        boolean hasValleyStarted = false;
        int elevation  = 0;
        int numOfValleys = 0;

        for(char step: pathArray) {
            if (step == 'D') {
                elevation -= 1;
            } else {
                elevation += 1;
            }

            if (elevation < 0 ) {
                hasValleyStarted = true;
            }

            if (elevation == 0 && hasValleyStarted) {
                hasValleyStarted = false;
                numOfValleys++;
            }
        }
        return numOfValleys;
    }
}
