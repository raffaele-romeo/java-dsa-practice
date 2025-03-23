package bitwise;

/**
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 */
public class MinimumFlipsToMakeIntEquals {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int cBit = (c >> i) & 1;

            if (cBit == 1) {
                if (aBit == 0 && bBit == 0) {
                    flips++;
                }
            } else {
                flips += aBit + bBit;
            }
        }

        return flips;
    }
}
