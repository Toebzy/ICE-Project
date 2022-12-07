import javax.swing.*;
import java.awt.*;

public class GUI{
        public GUI() {

                //String query = JOptionPane.showInputDialog("Enter the name of your Gnoxi");
                JFrame frame = new JFrame("Gnoxi-Tamer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 500);
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
                panel.setLayout(new GridLayout());

                JButton button1 = new JButton("Start Game");
                JButton button2 = new JButton("Gnoxi-dex");
                JButton button3 = new JButton("Exit Game");

                button1.setBounds(160, 200, 30, 30);
                button2.setBounds(180, 220, 30, 30);
                button3.setBounds(200, 240, 30, 30);

                frame.getContentPane().add(button1);
                frame.getContentPane().add(button2);
                frame.getContentPane().add(button3);
                
                frame.setVisible(true);
        }

}