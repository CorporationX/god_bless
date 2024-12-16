package school.faang.task49620;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("нагибатор228"),
                new Player("серёжа2004"),
                new Player("lehaps2001"),
                new Player("игрок")
        ));

        Boss boss = new Boss();

        List<Thread> threads = new ArrayList<>(List.of(
                new Thread(() ->
                        players.get(0).startBattle(boss)),
                new Thread(() ->
                        players.get(1).startBattle(boss)),
                new Thread(() ->
                        players.get(2).startBattle(boss)),
                new Thread(() ->
                        players.get(3).startBattle(boss))
        ));

        threads.forEach(Thread::start);

        players.stream().anyMatch(boss::exitBattle);

    }
}
