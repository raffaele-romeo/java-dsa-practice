package graph;

import java.util.*;

public class MaxIslandCount {
    // Grid values are '0' for water or '1' for land
    public static int islandCount(int[][] grid) {
        Set<String> visited = new HashSet<>();
        int maxIslandSize = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(i + "," + j)) {
                    maxIslandSize = Math.max(maxIslandSize, explore(grid, i, j, visited));
                }
            }
        }

        return maxIslandSize;
    }

    private static int explore(int[][] grid, int row, int col, Set<String> visited) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        visited.add(row + "," + col);
        int size = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            size++;

            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];
                String pos = newRow + "," + newCol;

                if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1 && !visited.contains(pos)) {

                    visited.add(pos);
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }

        return size;
    }
}
