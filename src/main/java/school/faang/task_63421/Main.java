package school.faang.task_63421;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Игрок 1");
        Thread thread1 = new Thread(() -> player1.doBattle(boss));
        thread1.start();

        Player player2 = new Player("Игрок 2");
        Thread thread2 = new Thread(() -> player2.doBattle(boss));
        thread2.start();

        Player player3 = new Player("Игрок 3");
        Thread thread3 = new Thread(() -> player3.doBattle(boss));
        thread3.start();

        Player player4 = new Player("Игрок 4");
        Thread thread4 = new Thread(() -> player4.doBattle(boss));
        thread4.start();

        Player player5 = new Player("Игрок 5");
        Thread thread5 = new Thread(() -> player5.doBattle(boss));
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

