package school.faang.sprint1.task_49716;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");

        Thread thread1 = new Thread(() -> player1.startBattle(boss));
        Thread thread2 = new Thread(() -> player2.startBattle(boss));
        Thread thread3 = new Thread(() -> player3.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
