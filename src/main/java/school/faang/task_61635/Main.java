package school.faang.task_61635;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss centaur = new Boss();
        List<Player> players = List.of(new Player("Bob"), new Player("Bill"), new Player("FIll"));

        for (Player player : players) {
            Thread thread = new Thread(() -> player.doBattle(centaur));
            thread.start();
        }
    }
}
