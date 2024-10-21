package school.faang.synchronization.supercow;

public class Main {
    private static final int MAX_PlAYERS = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PlAYERS);

        Player player1 = new Player("Abzalkhan");
        Player player2 = new Player("Olzhas");
        Player player3 = new Player("Aida");

        Thread thread1 = new Thread(() -> player1.startBattle(boss));
        Thread thread2 = new Thread(() -> player2.startBattle(boss));
        Thread thread3 = new Thread(() -> player3.startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
