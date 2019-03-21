package Field;

public class Cell {
    private byte neighboursNum;
    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public byte getNeighboursNum() {
        return neighboursNum;
    }

    public void setNeighboursNum(byte neighboursNum) {
        this.neighboursNum = neighboursNum;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
