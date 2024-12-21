package school.faang.sprint_3.task_bjs249673;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public class TestDataGenerator {
    public static List<Thread> getPlayersStartBattleThreads(List<Player> players, Boss boss) {
        return players.stream()
                .map(player -> new Thread(() -> player.startBattle(boss)))
                .toList();
    }

    public List<Player> getPlayers(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> new Player("Player " + i))
                .toList();
    }
}
