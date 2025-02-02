package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {
    public static List<Integer> printSpiral(int[][] mat) {
        List<Integer> output = new ArrayList<>();

        int rowCount = mat.length;
        int columnCount = mat[0].length;

        int top = 0;
        int bottom = rowCount - 1;
        int left = 0;
        int right = columnCount - 1;

        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++) {
                output.add(mat[top][i]);
            }

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++) {
                output.add(mat[i][right]);
            }

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    output.add(mat[bottom][i]);
                }

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    output.add(mat[i][left]);
                }

                left++;
            }
        }
        return output;
    }

    public static void main(String[] args) {

        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> ans = printSpiral(mat);

        for (Integer an : ans) {
            System.out.print(an + " ");
        }

        System.out.println();
    }
}