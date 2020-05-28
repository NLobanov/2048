package game;

import java.awt.*;

import static game.Config.*;

public class Point {
    private int value;

    public Point(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    void paint(Graphics g, int x, int y) {
        //rectangle settings
        int nX = x * BLOCK_SIZE + MARGIN;
        int nY = y * BLOCK_SIZE + MARGIN;
        int width = BLOCK_SIZE - MARGIN * 2;
        int height = BLOCK_SIZE - MARGIN * 2;

        //text settings
        String str = Integer.toString(value);
        FontMetrics metrics = g.getFontMetrics(MAIN_FONT);
        int a = nX + (width - metrics.stringWidth(str)) / 2;
        int b = nY + ((height - metrics.getHeight()) / 2) + metrics.getAscent();

        g.setColor(pickColor(value));
        g.fillRoundRect(nX, nY, width, height, CORNER_RADIUS, CORNER_RADIUS);
        g.setFont(MAIN_FONT);

        if (value < 8) g.setColor(COLOR_DARK_TEXT);
        else g.setColor(COLOR_LIGHT_TEXT);
        if (!str.equals("0")) g.drawString(str, a, b);
    }

    private Color pickColor(int value) {
        switch (value) {
            case 2:
                return COLOR_2;
            case 4:
                return COLOR_4;
            case 8:
                return COLOR_8;
            case 16:
                return COLOR_16;
            case 32:
                return COLOR_32;
            case 64:
                return COLOR_64;
            case 128:
                return COLOR_128;
            case 256:
                return COLOR_256;
            case 512:
                return COLOR_512;
            case 1024:
                return COLOR_1024;
            case 2048:
                return COLOR_2048;
            default:
                return COLOR_DEFAULT;
        }
    }
}
