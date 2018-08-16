package familyguy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JFrame {

    File background = new File("Background.jpg");
    JButton load = new JButton("   Load game   ");
    JButton newGame = new JButton("    New game   ");
    JButton about = new JButton("        About        ");
    JLabel fgmg = new JLabel("Family Guy Maze game");
    JButton peter = new JButton("Peter");
    JButton joe = new JButton("Joe");
    JButton quagmire = new JButton("Quagmire");
    JButton cleveland = new JButton("Cleveland");
    JPanel pMenu = new JPanel();
    JPanel pMenuCharacter = new JPanel();
    JPanel pMenuAbout = new JPanel();
    JLabel just = new JLabel(" ");
    JTextArea aboutText = new JTextArea();
    JButton backToMainMenu = new JButton("Back");
    BgPanel bg = new BgPanel();
    JPanel panel = new JPanel();

    public static void main(String[] args) {
        Menu gui = new Menu();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);

    }

    public Menu() {
        initWindow();
    }

    public void initWindow() {
        setTitle("Family Guy");
        setPreferredSize(new Dimension(750, 450));
        setLayout(new BorderLayout());
        bg.setLayout(new BorderLayout());
        setContentPane(bg);
        createMenuCharacters();
        createMenuAbout();
        createPanelMenu();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.add(pMenu, BorderLayout.WEST);
        panel.add(pMenuCharacter, BorderLayout.CENTER);
        panel.add(pMenuAbout, BorderLayout.EAST);
        bg.add(panel, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);

    }

    public void createPanelMenu() {
        pMenu.setLayout(new GridLayout(5, 2, 15, 15));
        newGame.setContentAreaFilled(false);
        load.setContentAreaFilled(false);
        about.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        load.setBorderPainted(false);
        about.setBorderPainted(false);
        pMenu.setOpaque(false);
        pMenu.add(just);
        pMenu.add(fgmg);
        pMenu.add(new JLabel(" "));
        pMenu.add(newGame);
        pMenu.add(new JLabel(" "));
        pMenu.add(load);
        pMenu.add(new JLabel(" "));
        pMenu.add(about);
        pMenu.add(new JLabel(" "));
        pMenu.add(new JLabel(" "));

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pMenu.setVisible(false);
                pMenuCharacter.setVisible(true);
            }
        });
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pMenu.setVisible(false);
                pMenuAbout.setVisible(true);
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog d = new LoadWindow();
            }
        });

    }

    public void createMenuCharacters() {
        JButton back = new JButton("Back to main menu");
        pMenuCharacter.setLayout(new GridLayout(6, 5, 15, 15));
        pMenuCharacter.setOpaque(false);

        joe.setContentAreaFilled(false);
        peter.setContentAreaFilled(false);
        quagmire.setContentAreaFilled(false);
        cleveland.setContentAreaFilled(false);
        back.setContentAreaFilled(false);

        joe.setBorderPainted(false);
        peter.setBorderPainted(false);
        quagmire.setBorderPainted(false);
        cleveland.setBorderPainted(false);
        back.setBorderPainted(false);

        JLabel newG = new JLabel("   New Game");
        newG.setFont(new Font("Times new roman", Font.PLAIN, 26));
        JLabel selectC = new JLabel("   Select character:");
        selectC.setFont(new Font("Times new roman", Font.PLAIN, 26));

        pMenuCharacter.add(newG);
        pMenuCharacter.add(new JLabel(" "));
        pMenuCharacter.add(selectC);
        pMenuCharacter.add(new JLabel(" "));
        pMenuCharacter.add(peter);
        pMenuCharacter.add(joe);
        pMenuCharacter.add(quagmire);
        pMenuCharacter.add(cleveland);
        pMenuCharacter.add(back);
        pMenuCharacter.setVisible(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pMenuCharacter.setVisible(false);
                pMenu.setVisible(true);
            }
        });
        joe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File joeFile = new File("Joe.png");
                Player joePlayer = new Player("Joe", joeFile, 1, 1, 1);
                JDialog easy = new EasyLevel(joePlayer);
            }
        });
        peter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File peterFile = new File("Peter Griffin.png");
                Player peterPlayer = new Player("Peter", peterFile, 1, 1, 1);
                JDialog easy = new EasyLevel(peterPlayer);

            }
        });
        quagmire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File quagmireFile = new File("Quagmire.png");
                Player quagmirePlayer = new Player("Quagmire", quagmireFile, 1, 1, 1);
                JDialog easy = new EasyLevel(quagmirePlayer);
            }
        });
        cleveland.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File clevelandFile = new File("Cleveland.png");
                Player clevelandPlayer = new Player("Cleveland", clevelandFile, 1, 1, 1);
                JDialog easy = new EasyLevel(clevelandPlayer);
            }
        });
    }

    public void createMenuAbout() {
        pMenuAbout.setLayout(new GridLayout(3, 2, 15, 15));
        pMenuAbout.setOpaque(false);
        aboutText.setEditable(false);
        aboutText.setText("Descriptin informing user that the game is for personal use and all characters are copyrighted for FOX company");
        aboutText.setOpaque(false);
        backToMainMenu.setContentAreaFilled(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setFont(new Font("Times new roman", Font.PLAIN, 14));
        backToMainMenu.setBorderPainted(false);
        JLabel aboutLabel = new JLabel("About:        ");
        aboutLabel.setFont(new Font("Times new roman", Font.PLAIN, 25));
        pMenuAbout.add(new JLabel(" "));
        pMenuAbout.add(aboutLabel);
        pMenuAbout.add(new JLabel(" "));
        pMenuAbout.add(aboutText);
        pMenuAbout.add(new JLabel(" "));
        pMenuAbout.add(backToMainMenu);
        backToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pMenu.setVisible(true);
                pMenuAbout.setVisible(false);
            }
        });
        pMenuAbout.setVisible(false);
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
