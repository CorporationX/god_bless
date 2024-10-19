package school.faang.broforce;

import java.util.Arrays;
import java.util.List;

public class MainBattle {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player("Georg", 5, 2),
                new Player("Alex", 5, 2));
        Game game = new Game(players);
        game.start();
    }
}
