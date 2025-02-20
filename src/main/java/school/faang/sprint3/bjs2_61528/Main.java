package school.faang.sprint3.bjs2_61528;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок1");
        Player player2 = new Player("Игрок2");
        Player player3 = new Player("Игрок3");
        Player player4 = new Player("Игрок4");

        final Thread thread1 = new Thread(() -> player1.doBattle(boss));
        final Thread thread2 = new Thread(() -> player2.doBattle(boss));
        final Thread thread3 = new Thread(() -> player3.doBattle(boss));
        final Thread thread4 = new Thread(() -> player4.doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
