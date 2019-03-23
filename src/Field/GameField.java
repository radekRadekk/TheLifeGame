package Field;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameField {
    private Cell[][] field;
    private boolean anyAlive;

    public boolean isAnyAlive() {
        return anyAlive;
    }

    public Cell[][] getField() {
        return field;
    }

    public GameField(int sizeX, int sizeY) {
        field = new Cell[sizeX][sizeY];
        for (int x = 0; x < sizeX; x++)
            for (int y = 0; y < sizeY; y++)
                field[x][y] = new Cell(false);
        anyAlive = false;
    }

    public void countNeighbours(String methodName) {
        if (methodName.equals("NEUMANN"))
            countNeighboursNeumann();
        else if (methodName.equals("MOORE")) {
            countNeighboursMoore();
        }
    }

    private void countNeighboursNeumann() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                byte neighboursNum = 0;

                if (areGoodCoords(x, y - 1))
                    if (field[x][y - 1].isAlive())
                        neighboursNum++;

                if (areGoodCoords(x, y + 1))
                    if (field[x][y + 1].isAlive())
                        neighboursNum++;

                if (areGoodCoords(x - 1, y))
                    if (field[x - 1][y].isAlive())
                        neighboursNum++;

                if (areGoodCoords(x + 1, y))
                    if (field[x + 1][y].isAlive())
                        neighboursNum++;

                field[x][y].setNeighboursNum(neighboursNum);
            }
        }
    }

    private void countNeighboursMoore() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[0].length; y++) {
                byte neighboursNum = 0;

                for (int i = (x - 1); i <= (x + 1); i++) {
                    for (int j = (y - 1); j <= (y + 1); j++) {
                        if (areGoodCoords(i, j) && ((i != x) || (j != y)))
                            if (field[i][j].isAlive())
                                neighboursNum++;
                    }
                }

                field[x][y].setNeighboursNum(neighboursNum);
            }
        }
    }

    private boolean areGoodCoords(int x, int y) {
        if ((x < 0) || (y < 0)) {
            return false;
        }
        if ((x >= field.length) || (y >= field[0].length)) {
            return false;
        }
        return true;
    }

    public void doGeneration(String gameRulesPattern) {
        Set<Byte> liveToLive = new HashSet<>();
        Set<Byte> deadToLive = new HashSet<>();

        String[] nums = gameRulesPattern.split("/");

        for (int i = 0; i < nums[0].length(); i++) {
            liveToLive.add(Byte.parseByte("" + nums[0].charAt(i)));
        }
        for (int i = 0; i < nums[1].length(); i++) {
            deadToLive.add(Byte.parseByte("" + nums[1].charAt(i)));
        }

        boolean anyAlive = false;
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[0].length; y++) {
                field[x][y].changeState(liveToLive, deadToLive);
                if (field[x][y].isAlive())
                    anyAlive = true;
            }
        }

        this.anyAlive = anyAlive;
    }


    public void setRandomCellsAlive(int num) {

        class Point {
            int coordX;
            int coordY;

            Point(int coordX, int coordY) {
                this.coordX = coordX;
                this.coordY = coordY;
            }
        }

        Random random = new Random();
        Set<Point> aliveCellsCoords = new HashSet<>();
        while (aliveCellsCoords.size() < num) {
            aliveCellsCoords.add(new Point(random.nextInt(field.length), random.nextInt(field[0].length)));
        }

        for (Point point : aliveCellsCoords) {
            field[point.coordX][point.coordY].setAlive(true);
        }

        anyAlive = true;
    }


}
