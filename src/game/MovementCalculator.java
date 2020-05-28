package game;

public class MovementCalculator {
    private MovementCalculator() {
    }

    static Point[][] movement(Point[][] map, Direction dir){
        Point[][] temp = map.clone();

        switch (dir){
            case UP:
            case DOWN:
                Point[][] swapped = MapUtils.swapRowsCols(temp);
                for (int i = 0; i < swapped.length; i++){
                    swapped[i] = moveRow(swapped[i], dir);
                }
                temp = MapUtils.swapRowsCols(swapped);
                break;
            case LEFT:
            case RIGHT:
                for (int i = 0; i < temp.length; i++){
                    temp[i] = moveRow(temp[i], dir);
                }
                break;
        }
        return MapUtils.addRandomPoint(temp);
    }

    private static Point[] moveRow(Point[] arr, Direction dir){
        Point[] temp = arr.clone();

        for (int i = 0; i < temp.length; i++){
            temp = sort(temp, dir);
        }

        temp = sum(temp, dir);

        for (int i = 0; i < temp.length; i++){
            temp = sort(temp, dir);
        }
        return temp;
    }

    private static Point[] sum(Point[] row, Direction dir){
        Point[] summed = row.clone();

        switch (dir) {
            case DOWN:
            case RIGHT:
                for (int i = summed.length - 1; i > 0; i--){
                    if (summed[i].getValue() == summed[i - 1].getValue()){
                        summed[i].setValue(summed[i].getValue() + summed[i - 1].getValue());
                        summed[i - 1].setValue(0);
                        Game.SCORE += summed[i].getValue();
                    }
                }
                break;
            case UP:
            case LEFT:
                for (int i = 0; i < summed.length - 1; i++){
                    if (summed[i].getValue() == summed[i + 1].getValue()) {
                        summed[i].setValue(row[i].getValue() + row[i + 1].getValue());
                        summed[i + 1].setValue(0);
                        Game.SCORE += summed[i].getValue();
                    }
                }
                break;
        }
        return summed;
    }

    private static Point[] sort(Point[] arr, Direction dir) {
        Point[] sorted = arr.clone();

        switch (dir) {
            case DOWN:
            case RIGHT:
                for (int i = sorted.length - 1; i > 0; i--) {
                    if (sorted[i].getValue() == 0 && sorted[i - 1].getValue() != 0) {
                        Point tmp = sorted[i];
                        sorted[i] = sorted[i - 1];
                        sorted[i - 1] = tmp;
                    }
                }
                break;
            case UP:
            case LEFT:
                for (int i = 0; i < arr.length - 1; i++) {
                    if (sorted[i].getValue() == 0 && sorted[i + 1].getValue() != 0) {
                        Point tmp = sorted[i];
                        sorted[i] = sorted[i + 1];
                        sorted[i + 1] = tmp;
                    }
                }
                break;
        }
        return sorted;
    }

    static boolean canMove(Point[][] map) {
        if (MapUtils.checkEmptySpace(map)) return true;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (isPointMovable(map, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean isPointMovable(Point[][] map, int y, int x) {
        int curr = map[y][x].getValue();

        if (x > 0) {
            if (curr == map[y][x - 1].getValue()) return true;
            if (y > 0)
                if (curr == map[y - 1][x].getValue()) return true;
        }

        if (x < map[y].length - 1) {
            if (curr == map[y][x + 1].getValue()) return true;
            if (y < map.length - 1)
                if (curr == map[y + 1][x].getValue()) return true;
        }
        return false;
    }
}
