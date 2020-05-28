package game;

import static game.Config.SIZE_X;
import static game.Config.SIZE_Y;

public class MapUtils {
    private MapUtils() {
    }

    static Point[][] swapRowsCols(Point[][] matrix) {
        Point[][] swapped = new Point[SIZE_X][SIZE_Y];

        for (int i = 0; i < swapped.length; i++) {
            for (int j = 0; j < swapped[i].length; j++) {
                swapped[i][j] = matrix[j][i];
            }
        }
        return swapped;
    }

    static boolean checkEmptySpace(Point[][] matrix) {
        for (Point[] points : matrix) {
            for (Point point : points) {
                if (point.getValue() == 0) return true;
            }
        }
        return false;
    }

    static int getMaxValue(Point[][] matrix) {
        int value = 0;

        for (Point[] points : matrix) {
            for (Point point : points) {
                if (point.getValue() > value)
                    value = point.getValue();
            }
        }
        return value;
    }

    static Point[][] addRandomPoint(Point[][] matrix) {
        Point[][] temp = matrix.clone();

        if (!checkEmptySpace(temp)) return temp;
        else {
            int[] point = new int[]{(int) (Math.random() * SIZE_Y), (int) (Math.random() * SIZE_X)};
            while (temp[point[0]][point[1]].getValue() != 0) {
                point = new int[]{(int) (Math.random() * SIZE_Y), (int) (Math.random() * SIZE_X)};
            }
            temp[point[0]][point[1]].setValue(Math.random() > 0.5 ? 2 : 4);
        }
        return temp;
    }
}
