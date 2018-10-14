package familyguy;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Game extends JDialog {

    JButton nextLevel = new JButton("Continue");
    JButton saveGame = new JButton("Save");
    JButton exit = new JButton("Exit");
    JPanel panel = new JPanel();
    private Player player;

    public Game(Player player) {
        this.player = player;
        setTitle("Load game");
        setPreferredSize(new Dimension(200, 200));
        createPanel();
        add(panel);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createPanel() {
        panel.setLayout(new GridLayout(3, 2, 15, 15));
        panel.add(nextLevel);
        panel.add(saveGame);
        panel.add(exit);
        nextLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getAchievedLevel() == 2) {
                    MediumLevel m = new MediumLevel(player);
                }
                if (player.getAchievedLevel() == 3) {
                    HardLevel h = new HardLevel(player);
                }
                dispose();
            }
        });
        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame("Save.txt", player);
                if (player.getAchievedLevel() == 2) {
                    MediumLevel m = new MediumLevel(player);
                }
                if (player.getAchievedLevel() == 3) {
                    HardLevel h = new HardLevel(player);
                }
                dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void saveGame(String fileName, Player player) {
        String text = player.getName() + "," + player.getCharacter() + "," + player.getAchievedLevel() + "," + 1 + "," + 1 + "\n";
        try {
            Files.write(Paths.get("Save.txt"), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
