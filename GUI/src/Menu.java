import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class Menu extends JFrame {
    private JButton startGameButton;
    private JButton exitGameButton;


    public Menu(){

        //MUSIC
        musicPlayer("Cascade");   //Titles = Cascade - Limerence - It's okay

        ImageIcon icon = new ImageIcon("Media/gnoxiIcon.png");
        ImageIcon gnoxiHeader = new ImageIcon("Media/gnoxiHeader.png");

        JFrame menuFrame = new JFrame("GnoxiWorld");

        startGameButton = new JButton("Start Game");                        //start-game button
        startGameButton.setBounds(100, 230, 275, 50);
        startGameButton.setFont(new Font("Arial", Font.BOLD, 15));
        startGameButton.setBackground(Color.white);

        exitGameButton = new JButton("Exit Game");                          //exit-game button
        exitGameButton.setBounds(100, 300, 275, 50);
        exitGameButton.setFont(new Font("Arial", Font.BOLD, 15));
        exitGameButton.setBackground(Color.white);

        JLabel gnoxiHead = new JLabel();                                        //menu title text and picture
        gnoxiHead.setIcon(gnoxiHeader);
        gnoxiHead.setText("G N O X I W O R L D");
        gnoxiHead.setFont(new Font("Segoe Print", Font.BOLD, 20));
        gnoxiHead.setVerticalTextPosition(JLabel.TOP);
        gnoxiHead.setHorizontalTextPosition(JLabel.CENTER);
        gnoxiHead.setBounds(120, 30, 250, 190);


        menuFrame.setIconImage(icon.getImage());                               //menu frame
        menuFrame.setSize(500, 500);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.add(startGameButton);
        menuFrame.add(exitGameButton);
        menuFrame.add(gnoxiHead);
        menuFrame.setLayout(null);
        menuFrame.setVisible(true);

        ButtonHandler handler = new ButtonHandler();                           //button handling
        startGameButton.addActionListener(handler);
        startGameButton.addActionListener(e ->{
        menuFrame.dispose();
        });
        exitGameButton.addActionListener(handler);

    }
    public static void musicPlayer(String title){                              //music handling
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Media/OST/"+title+".wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);   //loops the music
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startGameButton) {
                FileIO.checkForGnoxi();
            }
            if (e.getSource() == exitGameButton) {
                System.exit(0);
            }
        }
    }
}