package school.faang.m1s3.bjs2_37080_broforce;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Brobocop"),
                new Player("Brominator"),
                new Player("Brambo"),
                new Player("Chuck Broris"),
                new Player("Bro Lee")
        );

        Game game = new Game(players);

        game.startGame();
    }
}
