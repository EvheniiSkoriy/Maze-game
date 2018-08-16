package familyguy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EasyLevel extends Level {

    public static int startPosX = 1;
    public static int startPosY = 1;
    public static int endPosX = 10;
    public static int endPosY = 10;
    Image image;
    private int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1},
        {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1},
        {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1},
        {1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    private Player player;
    public static boolean finishEasy = false;
    private Graphics2D g2;

    public EasyLevel(Player player) {
        this.player = player;
        try {
            image = ImageIO.read(player.getCharacter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Easy Level");
        setPreferredSize(new Dimension(400, 400));
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public int[][] getMaze() {
        return maze;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawBoard(player,maze,g);

        g2 = (Graphics2D) g;
        g2.drawImage(image, player.getPositionX() * 30, player.getPositionY() * 30, 30, 30, null);
        if (player.getPositionX() == endPosX && player.getPositionY() == endPosY) {
            finishEasy = true;
            player.setAchievedLevel(2);
            if (EasyLevel.finishEasy) {
                player.setPositionX(1);
                player.setPositionY(1);
                Game d = new Game(player);
            }
            dispose();
        }
    }

    @Override
    public void processKeyEvent(KeyEvent event) {
        move(event,player,maze);
        repaint();
    }

}
