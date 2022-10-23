import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageHandler
{

    File imageFile = null;
    String filePath = null;
    BufferedImage buffImage = null;
    BufferedImage grayImage = null;
    public int[][] intensity;
    Random rand = new Random();

    public ImageHandler(String filePath)
    {
        this.filePath = filePath;
        try
        {
            initFile();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        grayImage = setGrayImage(buffImage);
    }

    public BufferedImage getImage()
    {
        return buffImage;
    }

    public BufferedImage getGrayImage()
    {
        initIntensity();
        return grayImage;
    }

    public void initFile() throws Exception
    {
        if(filePath == null)
        {
            throw new Exception("File path is not set");
        }
        try
        {
            imageFile = new File(filePath);
            buffImage = ImageIO.read(imageFile);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private BufferedImage setGrayImage(BufferedImage img)
    {
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = gray.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return gray;
    }

    public void initIntensity()
    {
        intensity = new int[grayImage.getHeight()][grayImage.getWidth()];
        for(int y = 0; y  < intensity.length; y++)
        {
            for(int x = 0; x < intensity[0].length; x++)
            {
                int darkness;
                int r, g, b;
                int rgb = grayImage.getRGB(x, y);
                b = (rgb) & 0xFF;
                g = (rgb >> 8) & 0xFF;
                r = (rgb >> 16) & 0xFF;
                darkness = 255 - ((r + g + b) / 3);
                intensity[y][x] = darkness;
            }
        }
    }

}
