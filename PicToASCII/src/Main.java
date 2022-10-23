public class Main
{


    public static void main(String[] args)
    {
        String path = "C:\\Users\\mhend\\OneDrive\\Desktop\\Jujutsu Kaisen Pics\\Itadori.jpg";
        ImageHandler imgHandler = new ImageHandler(path);
        Viewer view = new Viewer();
        view.setImage(imgHandler.getGrayImage());
        view.create();
        ASCIImage image = new ASCIImage(imgHandler.intensity);
        image.setAscii(new char[]{'.',',','^','%','#','&','@'});
        image.initImage();
        System.out.println(image.asciiString);
    }

}
