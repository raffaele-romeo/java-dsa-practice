package graph;

import java.util.HashSet;
import java.util.Set;

public class IslandCount {
    // Grid values are '0' for water or '1' for land
    public static int islandCount(char[][] grid) {
        var visited = new HashSet<String>();
        var count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (explore(grid, i, j, visited)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean explore(char[][] grid, int row, int col, Set<String> visited) {
        var rowInBounds = row >= 0 && row < grid.length;
        var colInBounds = col >= 0 && col < grid[0].length;

        if (!rowInBounds || !colInBounds) {
            return false;
        }

        if (grid[row][col] == '0') {
            return false;
        }

        var pos = row + "," + col;

        if (visited.contains(pos)) {
            return false;
        }

        visited.add(pos);

        explore(grid, row - 1, col, visited);
        explore(grid, row, col - 1, visited);
        explore(grid, row + 1, col, visited);
        explore(grid, row, col + 1, visited);

        return true;
    }
}
