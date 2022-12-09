import jdk.jshell.Snippet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class GUI{
        public GUI() {

              //  FileIO fileIO = new FileIO();
               // String nameQuery = null;
               // if (fileIO.checkForGnoxi()) {
               //         nameQuery = JOptionPane.showInputDialog("Enter the name of your Gnoxi");
               //         new Gnoxi(nameQuery, 0, 10, 0, 0, 10, System.currentTimeMillis());
              //          fileIO.writeNewGnoxiToCSV(nameQuery);
               // }

                ImageIcon icon = new ImageIcon("Media/gnoxiIcon.png");
                ImageIcon mediaGnoxi1 = new ImageIcon("Media/gnoxiGnoxi.png");
                JLabel gnoxi1 = new JLabel();
                gnoxi1.setIcon(mediaGnoxi1);
                gnoxi1.setText("Gnocchi 1"); //nameQuery
                gnoxi1.setVerticalTextPosition(JLabel.TOP);
                gnoxi1.setHorizontalTextPosition(JLabel.CENTER);
                gnoxi1.setVerticalAlignment(JLabel.CENTER);
                gnoxi1.setHorizontalAlignment(JLabel.CENTER);




               /* ImageIcon hungerIcon = new ImageIcon(("Media/StatusBars/hunger5.png");
                JLabel hungerStat = new JLabel();
                hungerStat.setText("Hunger");
                hungerStat.setVerticalTextPosition(JLabel.TOP);
                hungerStat.setHorizontalTextPosition(JLabel.CENTER);
                hungerStat.setFont(new Font("Arial", Font.BOLD, 20));
               hungerStat.setIcon(hungerIcon);
                hungerStat.setBounds(200,200,50,50);


                JPanel StatusField = new JPanel(new BorderLayout());
                StatusField.setLayout(new GridBagLayout());
                StatusField.add(hungerStat);




                JLabel happinessBar = new JLabel();
                JLabel poopBar = new JLabel();
                */


                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setResizable(true);
                frame.setVisible(true);
                frame.setTitle("Gnoxiworld");
                frame.setIconImage(icon.getImage()); //image of gnoxi
                frame.getContentPane().setBackground(ColorUIResource.PINK);
                frame.add(gnoxi1);
               // frame.add(hungerStat);


        }
}