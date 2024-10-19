package school.faang.broforce;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);
        int gameRounds = 100;
        Random random = new Random();

        for (int i = 0; i < gameRounds; i++) {
            boolean hasScored = random.nextBoolean();
            boolean lostLife = random.nextBoolean();
            game.update(hasScored, lostLife);
        }
    }
}
