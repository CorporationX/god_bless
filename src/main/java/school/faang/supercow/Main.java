package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("Boris");
        Player player2 = new Player("Igor");
        Player player3 = new Player("Vasya");

        Thread battleThread1 = new Thread(() -> {
            player1.doBattle(boss);
        });
        Thread battleThread2 = new Thread(() -> {
            player2.doBattle(boss);
        });
        Thread battleThread3 = new Thread(() -> {
            player3.doBattle(boss);
        });

        battleThread1.start();
        battleThread2.start();
        battleThread3.start();
    }
}
