package faang.school.godbless.multithreading.supercow;

import java.util.List;
import java.util.stream.IntStream;

public class Game {

    public static void main(String[] args) {

        Boss boss = new Boss(5);

        List<Thread> playerThreads = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new Player("Player-" + i))
                .map(player -> new Thread(() -> player.startBattle(boss)))
                .toList();

        playerThreads.forEach(Thread::start);
    }
}
