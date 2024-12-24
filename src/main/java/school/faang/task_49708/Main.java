package school.faang.task_49708;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Player player4 = new Player("Игрок 4");
        Player player5 = new Player("Игрок 5");

        Thread t1 = new Thread(() -> player1.startBattle(boss));
        Thread t2 = new Thread(() -> player2.startBattle(boss));
        Thread t3 = new Thread(() -> player3.startBattle(boss));
        Thread t4 = new Thread(() -> player4.startBattle(boss));
        Thread t5 = new Thread(() -> player5.startBattle(boss));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Сражение с боссом завершено!");
    }
}
