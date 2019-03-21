package Game;

public class ConfigurationFactory {

    public static Configuration createConfiguration(String[] args) {
        byte mode;
        int fieldSizeX;
        int fieldSizeY;
        int startAliveCellsNum;
        int iterationsNum;
        double imgCreationFrequency;
        String gameRules;
        String countingNeighboursMethod;

        //    -mo   mode of game:   2 - load last field; 1 - random field
        //    -x    field size X
        //    -y    field size Y
        //    -a    start number of alive cells
        //    -i    number of maximum games's iterations
        //    -f    frequency of saving the field with limit to be less than sqrt(iterations number)
        //    -r    game rules (pattern ddd/ddd)
        //    -me   counting neighbourhood method

        return new Configuration.Builder().build();
    }
}
