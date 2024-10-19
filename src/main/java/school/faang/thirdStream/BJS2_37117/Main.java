package school.faang.thirdStream.BJS2_37117;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            players.add(new Player(faker.superhero().name()));
        }

        Game game = new Game(players);
        game.startGame();
    }
}
