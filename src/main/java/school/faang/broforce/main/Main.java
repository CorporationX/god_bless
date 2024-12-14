package school.faang.broforce.main;

import school.faang.broforce.maincode.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            boolean scorePoints = Math.random() > 0.5;
            boolean loseLife = Math.random() > 0.75;

            game.update(scorePoints, loseLife);
        }
    }
}
