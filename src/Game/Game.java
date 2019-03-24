package Game;

import Field.GameField;
import IOImages.ImageSaver;
import javafx.scene.image.Image;

import java.io.IOException;

public class Game {

    public static void playGame(Configuration configuration) throws IOException {
        GameField field = new GameField(configuration.getFieldSizeX(), configuration.getFieldSizeY());
        if (configuration.getMode() == 1) {
            field.setRandomCellsAlive(configuration.getStartAliveCellsNum());
        }

        int itersNum = 0;
        while (itersNum < configuration.getIterationsNum() && field.isAnyAlive()) {
            if (itersNum % Math.round(Math.pow(configuration.getImgCreationFrequency(), -1.0)) == 0) {
                int itersTmp = itersNum;
               // new Thread(() -> {
                    Image image = ImageSaver.createImage(field);
                    try {
                        ImageSaver.saveImage(image, "C:/Users/rados/Desktop/pictures/picture" + itersTmp + ".png");
                    } catch (IOException e) {

                    }

               // }).start();

            }
            field.countNeighbours(configuration.getCountingNeighboursMethod());
            field.doGeneration(configuration.getGameRules());
            itersNum++;
        }

    }
}
