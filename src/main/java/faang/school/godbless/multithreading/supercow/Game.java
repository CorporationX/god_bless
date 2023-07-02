package faang.school.godbless.multithreading.supercow;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Game {

    public static void main(String[] args) {

        Boss boss = new Boss(5);

        List<Thread> playerThreads = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new Player("Player-" + i))
                .map(player -> new Thread(() -> player.startBattle(boss), player.getName()))
                .toList();

        playerThreads.forEach(thread -> System.out.println(thread.getName()));
        playerThreads.forEach(Thread::start);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(boss.getPlayers());

        boss.leaveBattle(boss.getPlayers().get(new Random().nextInt(boss.getCurrentPlayers())));
        boss.leaveBattle(boss.getPlayers().get(new Random().nextInt(boss.getCurrentPlayers())));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        boss.stopGame();
        System.out.println(boss.getPlayers());
    }
}
