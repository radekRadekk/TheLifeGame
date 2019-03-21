package Game;

import Field.GameField;

public class Game {

    public static void playGame(Configuration configuration) {
        GameField field = new GameField(configuration.getFieldSizeX(), configuration.getFieldSizeY());
        int itersNum = 0;
        while (itersNum < configuration.getIterationsNum() && field.isAnyAlive()) {
            //if (itersNum % Math.round(Math.pow(configuration.getImgCreationFrequency(), -1.0)) == 0)
                //createImage();
                field.doGeneration(configuration.getGameRules());
            itersNum++;
        }

    }
}
