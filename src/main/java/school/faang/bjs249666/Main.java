package school.faang.bjs249666;

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss(3);

        Player player1 = new Player("John");
        Player player2 = new Player("Sam");
        Player player3 = new Player("Tom");
        Player player4 = new Player("Alice");

        Thread t1 = new Thread(() -> {
            player1.startBattle(boss);
            player2.startBattle(boss);
            player3.startBattle(boss);
            player4.startBattle(boss);
        });

        Thread t2 = new Thread(() -> {
            boss.leaveBattle(player1);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted!");
        }

        System.out.println("Process is completed!");
    }
}
