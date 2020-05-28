package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static game.Config.*;
import static game.Direction.*;

public class Game extends JPanel {
    public static int SCORE;
    private int bestScore = 0;
    private int maxValue = 0;
    private boolean isGameOver = false;
    private boolean canMove = true;
    private Map board;

    public Game() {
        setPreferredSize(DIM);
        setBackground(COLOR_BG);
        setFocusable(true);
        startGame();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                updateMaxValue();
                updateCanMove();
                canEnd();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        move(UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        move(DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        move(LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        move(RIGHT);
                        break;
                    case KeyEvent.VK_SPACE:
                        startGame();
                }

                repaint();
            }
        });
    }

    public void startGame() {
        if(bestScore == 0) bestScore = SCORE;
        if(SCORE > bestScore) bestScore = SCORE;
        SCORE = 0;
        isGameOver = false;
        board = new Map();
    }

    public void updateMaxValue(){
        maxValue = MapUtils.getMaxValue(board.getMap());
    }

    public void updateCanMove(){
        canMove = MovementCalculator.canMove(board.getMap());
    }

    public void canEnd() {
        if (maxValue == 2048 || !canMove) {
            isGameOver = true;
        }
    }

    public void move(Direction dir) {
        if (!isGameOver) {
            Point[][] temp = MovementCalculator.movement(board.getMap(), dir);
            board.setMap(temp);
        }
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);

        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(COLOR_DARK_TEXT);
        g.setFont(MAIN_FONT);
        g.drawString("Score: " + SCORE, BLOCK_SIZE * SIZE_X + 30, 60);
        g.drawString("Best Score: " + bestScore, BLOCK_SIZE * SIZE_X + 30, 90);
        if(isGameOver) {
            g.setFont(MEDIUM_FONT);
            if(maxValue == 2048) {
                g.drawString("You won!", BLOCK_SIZE * SIZE_X + 30, 120);
            } else {
                g.drawString("You lose!", BLOCK_SIZE * SIZE_X + 30, 120);
            }
            g.drawString("Press Space to start a new game.", BLOCK_SIZE * SIZE_X + 30, 150);
        }
        board.drawMap(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle(TITLE);
            f.setResizable(false);
            f.add(new Game(), BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
