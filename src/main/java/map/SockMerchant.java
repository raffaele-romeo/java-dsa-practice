package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SockMerchant {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> colorCount  = new HashMap<>();

        for (Integer sock : ar) {
            colorCount.put(sock, colorCount.getOrDefault(sock, 0) + 1);
        }

        return colorCount.values().stream().map(x -> Math.floorDiv(x, 2))
                .reduce(0, Integer::sum);
    }
}

