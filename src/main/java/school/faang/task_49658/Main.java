package school.faang.task_49658;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("Гарри");
        Player player2 = new Player("Рон");
        Player player3 = new Player("Гермиона");
        Player player4 = new Player("Хагрит");
        Player player5 = new Player("Дамболдор");

        List<Player> playerThreads = List.of(player1, player2, player3, player4, player5);
        playerThreads.stream()
                .map((s) -> new Thread(() -> {
                    try {
                        s.startBattle(boss);
                    } catch (InterruptedException e) {
                        Boss.LOGGER.error("{} Ошибка сражения с боссом!", e.getMessage());
                    }
                }))
                .collect(Collectors.toList())
                .forEach(Thread::start);

    }
}
