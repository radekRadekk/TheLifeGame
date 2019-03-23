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
//            if (itersNum % Math.round(Math.pow(configuration.getImgCreationFrequency(), -1.0)) == 0) {
//                Image image = ImageSaver.createImage(field);
//                ImageSaver.saveImage(image, "C:/Users/rados/Desktop/pictures/picture" + itersNum + ".png");
//            }
            field.countNeighbours(configuration.getCountingNeighboursMethod());
            field.doGeneration(configuration.getGameRules());
            itersNum++;
        }

    }
}
