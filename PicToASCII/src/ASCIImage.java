public class ASCIImage
{

    int[][] intensity;
    char[] ascii;
    char[][] asciiImage;
    public String asciiString;
    double aspectRatio;
    int threshold;

    public ASCIImage(int[][] intensity)
    {
        this.intensity = intensity;
        aspectRatio = (double)intensity[0].length / (double)intensity.length;
    }

    public void setAscii(char[] ascii)
    {
        this.ascii = ascii;
        threshold = 255 / ascii.length;
    }

    public void initImage()
    {
        asciiImage = new char[intensity.length][intensity[0].length];
        for(int y = 0; y < intensity.length; y++)
        {
            for(int x = 0; x < intensity[0].length; x++)
            {
                //Picking ASCII Character
                int asciiIndex = 0;
                for(int i = 1; i <= ascii.length; i++)
                {
                    if(intensity[y][x] < threshold*i)
                    {
                        asciiIndex = i-1;
                        break;
                    }
                }
                asciiImage[y][x] = ascii[asciiIndex];
            }
        }
        setString();
    }

    private void setString()
    {
        String result = "";
        for(int y = 0; y < asciiImage.length; y++)
        {
            for(int x = 0; x < asciiImage[0].length; x++)
            {
                if(x == asciiImage[0].length - 1)
                {
                    result += asciiImage[y][x];
                    result += "\n";
                }
                else
                {
                    System.out.println("running...");
                    result += asciiImage[y][x];
                }
            }
        }
        System.out.println("done");
        asciiString = result;
    }


}
