package supercow;

import java.util.List;
import java.util.Random;

public class Main {
    private static final int MAX_PLAYERS = 3;
    private static final Random random = new Random();
    private static final List<String> playerNames = List.of("player", "John", "pr0", "b0$$_killer2010");

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        for (int i = 0; i < 10; i++) {
            getPlayerThread(boss).start();
        }
    }

    private static Thread getPlayerThread(Boss boss) {
        return new Thread(() ->
                boss.joinBattle(
                        new Player(generatePlayerName())
                )
        );
    }

    private static String generatePlayerName() {
        return playerNames.get(random.nextInt(playerNames.size())) + "#" + random.nextInt(1,2000);
    }
}
