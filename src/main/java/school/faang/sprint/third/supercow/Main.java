package school.faang.sprint.third.supercow;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Mika");
        Player player2 = new Player("Johny");
        Player player3 = new Player("Pedro");
        Player player4 = new Player("Carl");
        Player player5 = new Player("Vano");

        List<Thread> threads = List.of(
                new Thread(() -> player1.doBattle(boss)),
                new Thread(() -> player2.doBattle(boss)),
                new Thread(() -> player3.doBattle(boss)),
                new Thread(() -> player4.doBattle(boss)),
                new Thread(() -> player5.doBattle(boss))
        );

        threads.forEach(Thread::start);
    }
}
