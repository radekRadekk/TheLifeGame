package IOImages;

import Field.GameField;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageReader {
    public static Image readImage(String fileName) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(fileName);
        Image readImage = new Image(inputStream);
        return readImage;
    }

    public static GameField createFieldFromImage(Image image) {
        int sizeX = (int) image.getWidth();
        int sizeY = (int) image.getHeight();

        PixelReader pixelReader = image.getPixelReader();
        GameField newField = new GameField(sizeX, sizeY);

        for (int x = 0; x < sizeX; x++) {
            for (int y = sizeY - 1; y >= 0; y--) {
                if (pixelReader.getColor(x, y).equals(Color.WHITE)) {
                    newField.getField()[x][y].setAlive(true);
                    newField.setAnyAlive(true);
                } else {
                    newField.getField()[x][y].setAlive(false);
                }
            }
        }
        return newField;
    }

}
