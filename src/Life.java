import Game.Configuration;
import Game.ConfigurationFactory;
import Game.Game;

import java.io.IOException;

public class Life {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Configuration configuration = ConfigurationFactory.createConfiguration(args);
        Game.playGame(configuration);
        long finish = System.currentTimeMillis();
        System.out.println((finish - start) / 1000F);
    }
}



