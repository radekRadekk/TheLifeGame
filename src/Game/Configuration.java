package Game;

public class Configuration {
    private static final byte DEFAULT_MODE = 1;
    private static final int DEFAULT_FIELD_SIZE_X = 100;
    private static final int DEFAULT_FIELD_SIZE_Y = 100;
    private static final int DEFAULT_START_ALIVE_CELLS_NUM = 3333;
    private static final int DEFAULT_ITERATIONS_NUM = 100;
    private static final double DEFAULT_IMG_CREATION_FREQUENCY = 0.1;
    private static final String DEFAULT_GAME_RULES = "23/3";
    private static final String DEFAULT_COUNTING_NEIGHBOURS_METHOD = "MOORE";

    private byte mode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int startAliveCellsNum;
    private int iterationsNum;
    private double imgCreationFrequency;
    private String gameRules;
    private String countingNeighboursMethod;

    public byte getMode() {
        return mode;
    }

    public int getFieldSizeX() {
        return fieldSizeX;
    }

    public int getFieldSizeY() {
        return fieldSizeY;
    }

    public int getStartAliveCellsNum() {
        return startAliveCellsNum;
    }

    public int getIterationsNum() {
        return iterationsNum;
    }

    public double getImgCreationFrequency() {
        return imgCreationFrequency;
    }

    public String getGameRules() {
        return gameRules;
    }

    public String getCountingNeighboursMethod() {
        return countingNeighboursMethod;
    }

    private Configuration() {

    }

    public static final class Builder {
        private byte mode;
        private int fieldSizeX;
        private int fieldSizeY;
        private int startAliveCellsNum;
        private int iterationsNum;
        private double imgCreationFrequency;
        private String gameRules;
        private String countingNeighboursMethod;

        public Builder mode(byte mode) {
            this.mode = mode;
            return this;
        }

        public Builder fieldSizeX(int fieldSizeX) {
            this.fieldSizeX = fieldSizeX;
            return this;
        }

        public Builder fieldSizeY(int fieldSizeY) {
            this.fieldSizeY = fieldSizeY;
            return this;
        }

        public Builder startAliveCellsNum(int startAliveCellsNum) {
            this.startAliveCellsNum = startAliveCellsNum;
            return this;
        }

        public Builder iterationsNum(int iterationsNum) {
            this.iterationsNum = iterationsNum;
            return this;
        }

        public Builder imgCreationFrequency(double imgCreationFrequency) {
            this.imgCreationFrequency = imgCreationFrequency;
            return this;
        }

        public Builder gameRules(String gameRules) {
            this.gameRules = gameRules;
            return this;
        }

        public Builder countingNeighboursMethod(String countingNeighboursMethod) {
            this.countingNeighboursMethod = countingNeighboursMethod;
            return this;
        }

        public Configuration build() {
            if (this.mode != 1 && this.mode != 2)
                this.mode = DEFAULT_MODE;
            if (this.fieldSizeX <= 0)
                this.fieldSizeX = DEFAULT_FIELD_SIZE_X;
            if (this.fieldSizeY <= 0)
                this.fieldSizeY = DEFAULT_FIELD_SIZE_Y;
            if (this.startAliveCellsNum < 1)
                this.startAliveCellsNum = DEFAULT_START_ALIVE_CELLS_NUM;
            if (this.iterationsNum < 1)
                this.iterationsNum = DEFAULT_ITERATIONS_NUM;
            if (this.imgCreationFrequency <= 0 || this.imgCreationFrequency > 1)
                this.imgCreationFrequency = DEFAULT_IMG_CREATION_FREQUENCY;
            if (!isGoodGameRulesPattern(this.gameRules))
                this.gameRules = DEFAULT_GAME_RULES;
            if (this.countingNeighboursMethod == null || (!this.countingNeighboursMethod.equals("MOORE") && !this.countingNeighboursMethod.equals("NEUMANN")))
                this.countingNeighboursMethod = DEFAULT_COUNTING_NEIGHBOURS_METHOD;

            Configuration configuration = new Configuration();
            configuration.mode = this.mode;
            configuration.fieldSizeX = this.fieldSizeX;
            configuration.fieldSizeY = this.fieldSizeY;
            configuration.startAliveCellsNum = this.startAliveCellsNum;
            configuration.iterationsNum = this.iterationsNum;
            configuration.imgCreationFrequency = this.imgCreationFrequency;
            configuration.gameRules = this.gameRules;
            configuration.countingNeighboursMethod = this.countingNeighboursMethod;

            return configuration;
        }
    }

    private static boolean isGoodGameRulesPattern(String gameRulesPattern) {
        if (gameRulesPattern == null)
            return false;

        boolean wasSlash = false;

        if (gameRulesPattern.charAt(gameRulesPattern.length() - 1) == '/') {
            return false;
        }

        if (gameRulesPattern.charAt(0) == '/') {
            return false;
        }

        for (int i = 0; i < gameRulesPattern.length(); i++) {
            if (gameRulesPattern.charAt(i) == '/') {
                if (wasSlash)
                    return false;
                else
                    wasSlash = true;
            }
            if (!Character.isDigit(gameRulesPattern.charAt(i)))
                return false;
        }

        if (!wasSlash) {
            return false;
        }

        return true;
    }
}
