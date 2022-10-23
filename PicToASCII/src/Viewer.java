import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Viewer
{
    JFrame frame;
    BufferedImage displayImage;

    public void setImage(BufferedImage image)
    {
        displayImage = image;
    }

    public void create()
    {
        frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(displayImage)));
        frame.setVisible(true);
    }
}
