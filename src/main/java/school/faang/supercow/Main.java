package school.faang.supercow;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Player player4 = new Player("Игрок 4");

        List<Thread> threads = List.of(
                new Thread(() -> player1.doBattle(boss)),
                new Thread(() -> player2.doBattle(boss)),
                new Thread(() -> player3.doBattle(boss)),
                new Thread(() -> player4.doBattle(boss))
        );

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
