package game;

import java.awt.*;

public final class Config {
    static final String TITLE = "2048";
    static final int BLOCK_SIZE = 100;
    static final int MARGIN = 6;
    static final int CORNER_RADIUS = 10;
    static final int SIZE_X = 4;
    static final int SIZE_Y = 4;
    static final Dimension DIM = new Dimension(BLOCK_SIZE * SIZE_X * 2, BLOCK_SIZE * SIZE_Y);

    static final Font MAIN_FONT = new Font("Monospaced", Font.BOLD, 32);
    static final Font MEDIUM_FONT = MAIN_FONT.deriveFont(Font.BOLD, 18);

    static final Color COLOR_DARK_TEXT = new Color(0x776E65);
    static final Color COLOR_LIGHT_TEXT = new Color(0xF9F6F2);
    static final Color COLOR_BG = new Color(0xBBADA0);
    static final Color COLOR_2 = new Color(0xEEE4DA);
    static final Color COLOR_4 = new Color(0xEDE0C8);
    static final Color COLOR_8 = new Color(0xF2B179);
    static final Color COLOR_16 = new Color(0xF59563);
    static final Color COLOR_32 = new Color(0xF67C60);
    static final Color COLOR_64 = new Color(0xF65E3B);
    static final Color COLOR_128 = new Color(0xEDCF73);
    static final Color COLOR_256 = new Color(0xEDCC62);
    static final Color COLOR_512 = new Color(0xEDC850);
    static final Color COLOR_1024 = new Color(0xEDC53F);
    static final Color COLOR_2048 = new Color(0xEDC22D);
    static final Color COLOR_DEFAULT = new Color(0xCDC1B4);

    private Config() {
    }
}
