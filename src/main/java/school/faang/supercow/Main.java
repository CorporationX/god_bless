package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        Thread thread1 = new Thread(() -> player1.doBattle(boss));
        thread1.start();

        Thread thread2 = new Thread(() -> player2.doBattle(boss));
        thread2.start();

        Thread thread3 = new Thread(() -> player3.doBattle(boss));
        thread3.start();

        Thread thread4 = new Thread(() -> player4.doBattle(boss));
        thread4.start();
    }
}
