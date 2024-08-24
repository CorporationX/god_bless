package faang.school.godbless.sprint.three.supercow;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String... args) {

        List<Player> players = new ArrayList<>(List.of(
                new Player("Vasia"), new Player("Kolia"),
                new Player("Petia"), new Player("Tolik"),
                new Player("John"), new Player("Dan")
        ));
        Boss boss = new Boss();

        players.forEach(player -> new Thread(() -> player.startBattle(boss)).start());

    }
}
