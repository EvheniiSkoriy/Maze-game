package familyguy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level extends JDialog {
    public Level() {
    }

    public static void move(KeyEvent event,Player player,int[][] maze){
        if (event.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        int keyCode = event.getKeyCode();
        int x = player.getPositionX();
        int y = player.getPositionY();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (maze[x][y - 1] == 1) {
                } else {
                    player.setPositionY(y - 1);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (maze[x][y + 1] == 1) {
                } else {
                    player.setPositionY(y + 1);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (maze[x - 1][y] == 1) {
                } else {
                    player.setPositionX(x - 1);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (maze[x + 1][y] == 1) {

                } else {
                    player.setPositionX(x + 1);
                }
                break;

            default:
                break;
        }
    }

    public static void drawBoard(Player player,int[][] maze,Graphics g){
        for (int row = player.getPositionX() - 1; row <= player.getPositionX() + 1; row++) {
            for (int col = player.getPositionY() - 1; col <= player.getPositionY() + 1; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * row, 30 * col, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * row, 30 * col, 30, 30);
            }
        }
    }
}
