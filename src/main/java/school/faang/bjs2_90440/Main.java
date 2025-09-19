package school.faang.bjs2_90440;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Player player1 = new Player("Петя");
        Player player2 = new Player("Вася");
        Player player3 = new Player("Федя");
        Player player4 = new Player("Даша");
        Player player5 = new Player("Маша");
        Player player6 = new Player("Оля");
        Player player7 = new Player("Гена");
        Player player8 = new Player("Лида");
        Thread thread = new Thread(() -> player1.doBattle(boss));

        );
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread thread = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

    }
}
