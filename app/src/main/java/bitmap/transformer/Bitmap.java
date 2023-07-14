package bitmap.transformer;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Bitmap {

    private BufferedImage image;
    public Bitmap(BufferedImage originalImage) {
        this.image = originalImage;
    }

    public void negative() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixel = new Color(image.getRGB(x, y));

                int red = 255 - pixel.getRed();
                int green = 255 - pixel.getGreen();
                int blue = 255 - pixel.getBlue();

                Color negativePixel = new Color(red, green, blue);
                image.setRGB(x, y, negativePixel.getRGB());
            }
        }
    }

    public void addBorder(){
        int width = image.getWidth();
        int height = image.getHeight();
        // Create a new image with increased dimensions
        int newWidth = width + 2 * 3;
        int newHeight = height + 2 * 3;
        int borderWidth = 20;
        int borderColor = 0xFF0000;

        // Set the border color for the new image
        for (int i = 0; i < newWidth; i++) {
            for (int j = 0; j < newHeight; j++) {
                if (i < borderWidth || i >= newWidth - borderWidth || j < borderWidth || j >= newHeight - borderWidth) {
                    image.setRGB(i, j, borderColor);
                } else {
                    int rgb = image.getRGB(i - borderWidth, j - borderWidth);
                    image.setRGB(i, j, rgb);
                }
            }
        }

    }

    public void flip() {
        int width = image.getWidth();
        int height = image.getHeight();

        int[] temp = new int[width];
        // chatGPT assisted with the formula for flipping an image
        for (int i=0; i < width;i++){
            for (int j=0; j < height/2; j++){
                int rgb = image.getRGB(i,j);

                temp[j] = rgb;

                image.setRGB(i, j, image.getRGB(i, height - j - 1));
                image.setRGB(i, height - j - 1, temp[j]);
            }
        }
    }


        public BufferedImage getBufferedImage() {
        return this.image;
    }
}
