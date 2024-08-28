package faang.school.godbless.BJS2_24199;


import java.util.ArrayList;
import java.util.List;

public class Supercow {
    public static void main(String[] args) {
        var boss = new Boss(2);
        var players = new ArrayList<>(
                List.of(
                        new Player("Player1"),
                        new Player("Player2"),
                        new Player("Player3"),
                        new Player("Player4"),
                        new Player("Player5"),
                        new Player("Player6")
                )
        );
        var threads = players.stream()
                .map(player -> new Thread(() -> player.startBattle(boss)))
                .toList();

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Battle is over");
    }
}
