package game;

import java.awt.*;
import static game.Config.SIZE_X;
import static game.Config.SIZE_Y;

public class Map {
    private game.Point[][] map = new game.Point[SIZE_X][SIZE_Y];

    public Map() {
        initMap();
    }

    private void initMap(){
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                map[i][j] = new game.Point(0);
            }
        }
        map = MapUtils.addRandomPoint(map);
        map = MapUtils.addRandomPoint(map);
    }

    public game.Point[][] getMap() {
        return map;
    }

    public void setMap(Point[][] map) {
        this.map = map;
    }

    public void drawMap(Graphics2D g){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j].paint(g, j, i);
            }
        }
    }
}
