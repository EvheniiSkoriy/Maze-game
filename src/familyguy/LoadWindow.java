package familyguy;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LoadWindow extends JDialog {

    File background = new File("Background.jpg");
    JList loadPlayers = new JList();
    JLabel choose = new JLabel("Choose the game");

    public LoadWindow() {
        BgPanel bg = new BgPanel();
        bg.setLayout(new GridLayout(1, 1, 10, 10));
        setContentPane(bg);

        ArrayList<Player> players = loadGame("Save.txt");
        DefaultListModel player = new DefaultListModel();
        for (Player p : players) {
            player.addElement(p);
        }
        loadPlayers.setModel(player);
        loadPlayers.setOpaque(false);
        loadPlayers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Player pl = (Player) loadPlayers.getSelectedValue();
                switch (pl.getAchievedLevel()) {
                    case 1: {
                        EasyLevel m = new EasyLevel(pl);
                        dispose();
                        break;
                    }
                    case 2: {
                        MediumLevel m = new MediumLevel(pl);
                        dispose();
                        break;
                    }
                    case 3:
                        HardLevel h = new HardLevel(pl);
                        dispose();
                        break;
                    default:
                        break;
                }
            }
        });
        choose.setFont(new Font("Times new roman", Font.PLAIN, 20));
        bg.add(choose);
        bg.add(new JScrollPane(loadPlayers));

        setTitle("Load game");
        setPreferredSize(new Dimension(450, 250));
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static ArrayList<Player> loadGame(String fileName) {
        BufferedReader reader = null;
        String line;
        ArrayList<Player> list = new ArrayList();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                File character = new File(array[1]);

                Player p = new Player(array[0], character, Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]));
                list.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
        }
        return list;
    }

    class BgPanel extends JPanel {

        public void paintComponent(Graphics g) {
            Image im = null;
            try {
                im = ImageIO.read(background);
            } catch (IOException e) {
            }
            g.drawImage(im, 0, 0, null);
        }
    }
}
