package school.faang.bjs2_61673;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        int numberOfPlayers = 5;

        for (int i = 0; i < numberOfPlayers; i++) {
            new Thread(() -> {
                Random random = new Random();

                while (!game.isGameOver()) {
                    ActionType action = getRandomAction(random);
                    game.update(action);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Player-" + (i + 1)).start();
        }
    }

    private static ActionType getRandomAction(Random random) {
        ActionType[] actions = ActionType.values();
        return actions[random.nextInt(actions.length)];
    }
}
