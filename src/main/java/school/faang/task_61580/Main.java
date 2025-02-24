package school.faang.task_61580;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss("Маления", 1);

        Player firstPlayer = new Player("Первый Погасший");
        Player secondPlayer = new Player("Второй Погасший");
        Player thirdPlayer = new Player("Третий Погасший");
        List<Player> players = new ArrayList<>(List.of(firstPlayer, secondPlayer, thirdPlayer));

        List<Thread> threads = new ArrayList<>();
        players.forEach(player -> threads.add(new Thread(() -> player.doBattle(boss))));

        threads.forEach(Thread::start);
    }
}
