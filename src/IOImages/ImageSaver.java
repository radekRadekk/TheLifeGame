package IOImages;

import Field.GameField;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageSaver {

    public static Image createImage (GameField gameField) {
        int height = gameField.getField()[0].length;
        int width = gameField.getField().length;
        Image image = new WritableImage(width, height);
        PixelWriter pixelWriter = ((WritableImage) image).getPixelWriter();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (gameField.getField()[x][y].isAlive()) {
                    pixelWriter.setColor(x, y, Color.WHITE);
                } else {
                    pixelWriter.setColor(x, y, Color.BLACK);
                }
            }
        }

        return image;
    }

    public static void saveImage(Image image, String fileName) throws IOException {
        File file = new File(fileName);
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
    }

}
