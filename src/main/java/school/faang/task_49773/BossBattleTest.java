package school.faang.task_49773;

public class BossBattleTest {
    private static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");

        Thread thread1 = new Thread(() -> player1.startBattle(boss));
        Thread thread2 = new Thread(() -> player2.startBattle(boss));
        Thread thread3 = new Thread(() -> player3.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            Thread.currentThread().interrupt();
        }
    }
}

