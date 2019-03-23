package Game;

public class ConfigurationFactory {

    public static Configuration createConfiguration(String[] args) {
        byte mode = -1;
        int fieldSizeX = -1;
        int fieldSizeY = -1;
        int startAliveCellsNum = -1;
        int iterationsNum = -1;
        double imgCreationFrequency = -1.0;
        String gameRules = null;
        String countingNeighboursMethod = null;

        //    -mo   mode of game:   2 - load last field; 1 - random field
        //    -x    field size X
        //    -y    field size Y
        //    -a    start number of alive cells
        //    -i    number of maximum games's iterations
        //    -f    frequency of saving the field with limit to be less than sqrt(iterations number)
        //    -r    game rules (pattern ddd/ddd)
        //    -me   counting neighbourhood method

        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-mo") && args[i + 1].matches("\\d+"))
                mode = Byte.parseByte(args[i + 1]);
            if (args[i].equals("-x") && args[i + 1].matches("\\d+"))
                fieldSizeX = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-y") && args[i + 1].matches("\\d+"))
                fieldSizeY = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-a") && args[i + 1].matches("\\d+"))
                startAliveCellsNum = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-i") && args[i + 1].matches("\\d+"))
                iterationsNum = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-f") && args[i + 1].matches("\\d++[.]+\\d+"))
                imgCreationFrequency = Double.parseDouble(args[i + 1]);
            if (args[i].equals("-r"))
                gameRules = args[i + 1];
            if (args[i].equals("-me"))
                countingNeighboursMethod = args[i + 1];
        }

        return new Configuration.Builder().
                mode(mode).
                fieldSizeX(fieldSizeX).
                fieldSizeY(fieldSizeY).
                startAliveCellsNum(startAliveCellsNum).
                iterationsNum(iterationsNum).
                imgCreationFrequency(imgCreationFrequency).
                gameRules(gameRules).
                countingNeighboursMethod(countingNeighboursMethod).
                build();
    }
}
