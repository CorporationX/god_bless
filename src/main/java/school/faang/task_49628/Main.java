package school.faang.task_49628;

import java.util.stream.Stream;

public class Main {
    private static final int MAX_PLAYERS = 3;

    private static final Boss BOSS = new Boss(MAX_PLAYERS);

    public static void main(String[] args) {
        Stream.of(
                new Player("John"),
                new Player("Robert"),
                new Player("Michael"),
                new Player("James"),
                new Player("William")
        ).forEach(player -> new Thread(() -> player.startBattle(BOSS)).start());
    }

}
