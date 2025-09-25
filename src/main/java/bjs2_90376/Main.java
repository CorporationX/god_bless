package bjs2_90376;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок 1");
        Thread t1 = new Thread(() -> player1.doBattle(boss));
        t1.start();
        Player player2 = new Player("Игрок 2");
        Thread t2 = new Thread(() -> player2.doBattle(boss));
        t2.start();
        Player player3 = new Player("Игрок 3");
        Thread t3 = new Thread(() -> player3.doBattle(boss));
        t3.start();
        Player player4 = new Player("Игрок 4");
        Thread t4 = new Thread(() -> player4.doBattle(boss));
        t4.start();

    }
}
