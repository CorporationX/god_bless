package school.faang.bjs2_82156;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("David");
        Player player2 = new Player("Musk");
        Player player3 = new Player("Lopez");
        Player player4 = new Player("Jenifer");

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
