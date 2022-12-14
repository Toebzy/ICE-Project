import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class Menu extends JFrame {
    private JButton startGameButton;
    private JButton exitGameButton;
    private JButton settingsButton;
    private JFrame menuFrame;

    public Menu(){

        ImageIcon icon = new ImageIcon("Media/gnoxiIcon.png");
        ImageIcon gnoxiHeader = new ImageIcon("Media/gnoxiHeader.png");

        menuFrame = new JFrame("GnoxiWorld");

        startGameButton = new JButton("Start Game");                        //start-game button
        startGameButton.setBounds(100, 240, 275, 50);
        startGameButton.setFont(new Font("Arial", Font.BOLD, 15));
        startGameButton.setBackground(Color.white);
        startGameButton.setFocusPainted(false);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(100, 300, 275, 50);
        settingsButton.setFont(new Font("Arial", Font.BOLD, 15));
        settingsButton.setBackground(Color.white);
        settingsButton.setFocusPainted(false);

        exitGameButton = new JButton("Exit Game");                          //exit-game button
        exitGameButton.setBounds(100, 360, 275, 50);
        exitGameButton.setFont(new Font("Arial", Font.BOLD, 15));
        exitGameButton.setBackground(Color.white);
        exitGameButton.setFocusPainted(false);

        JLabel gnoxiHead = new JLabel();                                        //menu title text and picture
        gnoxiHead.setIcon(gnoxiHeader);
        gnoxiHead.setBackground(ColorUIResource.WHITE);
        gnoxiHead.setText("G N O X I W O R L D");
        gnoxiHead.setFont(new Font("Arial", Font.BOLD, 20));
        gnoxiHead.setVerticalTextPosition(JLabel.TOP);
        gnoxiHead.setHorizontalTextPosition(JLabel.CENTER);
        gnoxiHead.setBounds(120, 30, 250, 190);


        menuFrame.setIconImage(icon.getImage());                               //menu frame
        menuFrame.setSize(500, 500);
        menuFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.add(startGameButton);
        menuFrame.add(settingsButton);
        menuFrame.add(exitGameButton);
        menuFrame.add(gnoxiHead);
        menuFrame.setLayout(null);
        menuFrame.setVisible(true);

        ButtonHandler handler = new ButtonHandler();                           //button handling
        startGameButton.addActionListener(handler);
        settingsButton.addActionListener(handler);
        settingsButton.addActionListener(e ->{
            menuFrame.dispose();
        });
        exitGameButton.addActionListener(handler);

    }
    private JButton returnButton;
    private JButton musicButton;
    private JButton resetButton;
    private JButton motherlode;
    private JFrame settingsFrame;
    public void settings(){
        ImageIcon logo = new ImageIcon("Media/gnoxiIcon.png");

        returnButton = new JButton("Return to Menu");
        musicButton = new JButton();
        resetButton = new JButton("Reset Progress");
        motherlode = new JButton(); // ;)
        JLabel titleText = new JLabel();

        titleText.setBounds(65,100,400,50);
        titleText.setText("S E T T I N G S");
        titleText.setFont(new Font("Arial", Font.BOLD, 50));

        returnButton.setBounds(100, 300, 275, 50);
        returnButton.setFont(new Font("Arial", Font.BOLD, 15));
        returnButton.setBackground(Color.white);
        returnButton.setFocusPainted(false);

        musicButton.setBounds(100, 180, 275, 50);
        musicButton.setText("Music: ON");
        musicButton.setFont(new Font("Arial", Font.BOLD, 15));
        musicButton.setBackground(Color.white);
        musicButton.setFocusPainted(false);

        resetButton.setBounds(100, 240, 275, 50);
        resetButton.setFont(new Font("Arial", Font.BOLD, 15));
        resetButton.setBackground(Color.white);
        resetButton.setFocusPainted(false);

        motherlode.setBounds(0, 412, 50, 50);
        motherlode.setText("");
        motherlode.setOpaque(false);
        motherlode.setContentAreaFilled(false);
        motherlode.setBorderPainted(false);
       // motherlode.setFocusPainted(false);

        ButtonHandler handler = new ButtonHandler();
        returnButton.addActionListener(handler);
        musicButton.addActionListener(handler);
        resetButton.addActionListener(handler);
        motherlode.addActionListener(handler);



        settingsFrame = new JFrame();
        settingsFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        settingsFrame.setIconImage(logo.getImage());
        settingsFrame.setSize(500, 500);
        settingsFrame.setResizable(false);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setVisible(true);
        settingsFrame.setTitle("Settings");
        settingsFrame.add(returnButton);
        settingsFrame.add(musicButton);
        settingsFrame.add(resetButton);
        settingsFrame.add(motherlode);
        settingsFrame.add(titleText);
        settingsFrame.setLayout(null);


    }


    private static Clip clip;
    public static int onOff = 1;
        public static void musicPlayer(String title){                              //music handling
         if (clip != null && clip.isRunning()) { clip.stop(); }
        try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Media/OST/" + title + ".wav").getAbsoluteFile());
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);   //loops the music

        } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==returnButton){
                settingsFrame.dispose();
                new Menu();
            }
            if (e.getSource()==resetButton){
                GUI.newGnoxi();
                settingsFrame.dispose();
            }
            if (e.getSource()==musicButton){
                if (onOff==1){
                    musicButton.setText("Music: OFF");
                    musicButton.repaint();
                    clip.stop();
                    onOff = 0;
                }
                else {
                    musicButton.setText("Music: ON");
                    musicButton.repaint();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    onOff = 1;
                }
            }
            if (e.getSource() == startGameButton) {
                FileIO.checkForGnoxi();
                menuFrame.dispose();
            }
            if (e.getSource() == exitGameButton) {
                System.exit(0);
            }
            if(e.getSource()==settingsButton){
                settings();
            }
            if(e.getSource()==motherlode){
                System.out.println("WORKS WORKS WORKS");
               // Gnoxi.(50000); // ;)
            }
        }
    }
}