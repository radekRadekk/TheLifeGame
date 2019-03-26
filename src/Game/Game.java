package Game;

import Field.Cell;
import Field.GameField;
import IOImages.ImageReader;
import IOImages.ImageSaver;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Game {

    public static void playGame(Configuration configuration) throws IOException {
        GameField field = new GameField(configuration.getFieldSizeX(), configuration.getFieldSizeY());
        if (configuration.getMode() == 1) {
            field.setRandomCellsAlive(configuration.getStartAliveCellsNum());
        }
        if (configuration.getMode() == 2) {
            try {
                Image image = ImageReader.readImage("C:/Users/rados/Desktop/pictures/input.png");
                field = ImageReader.createFieldFromImage(image);
            } catch (FileNotFoundException e) {

            }
        }

        int itersNum = 0;
        while (itersNum < configuration.getIterationsNum() && field.isAnyAlive()) {
            if (itersNum % Math.round(Math.pow(configuration.getImgCreationFrequency(), -1.0)) == 0) {
                GameField copyOfField =
                        field.doGeneration(configuration.getGameRules(), configuration.getCountingNeighboursMethod());
                int itersTmp = itersNum;
                new Thread(() -> {
                    Image image = ImageSaver.createImage(copyOfField);
                    try {
                        ImageSaver.saveImage(image, "C:/Users/rados/Desktop/pictures/picture" + itersTmp + ".png");
                    } catch (IOException e) {

                    }

                }).start();
            }
            itersNum++;
        }

    }
}
