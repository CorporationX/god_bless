package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Boss boss1 = new Boss("Boss1", 2);
        Thread thread1 = new Thread(() -> {
            player1.doBattle(boss1);
        });
        Thread thread2 = new Thread(() -> {
            player2.doBattle(boss1);
        });
        Thread thread3 = new Thread(() -> {
            player3.doBattle(boss1);
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
