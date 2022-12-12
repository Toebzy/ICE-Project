import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
import java.awt.*;

public class ImageProgressBarUI extends ProgressBarUI {
    private ImageIcon icon;

    public ImageProgressBarUI(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        // Get the dimensions of the progress bar
        int width = c.getWidth();
        int height = c.getHeight();

        // Draw the progress bar
        super.paint(g, c);

        // Calculate the position of the image
        int x = (width - icon.getIconWidth()) / 2;
        int y = (height - icon.getIconHeight()) / 2;

        // Draw the image on top of the progress bar
        icon.paintIcon(c, g, x, y);
    }
}