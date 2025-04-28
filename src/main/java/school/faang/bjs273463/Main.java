package school.faang.bjs273463;

import java.util.stream.IntStream;

public class Main {

    private static final int MAX_PLAYERS = 3;
    private static final int TOTAL_PLAYERS = 15;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        IntStream.rangeClosed(1, TOTAL_PLAYERS)
                .forEach(i -> {
                    Player player = new Player("Игрок " + i);
                    Thread thread = new Thread(() -> player.doBattle(boss), player.getName());
                    thread.start();
                });
    }
}
