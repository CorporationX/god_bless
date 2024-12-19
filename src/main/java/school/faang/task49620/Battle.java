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

        players.forEach(player -> new Thread(() -> player.startBattle(boss)).start());

        players.stream().anyMatch(boss::exitBattle);
    }
}
