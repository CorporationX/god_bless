package school.faang.suprcow_BJS2_36774;

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss(3, 0);
        Player player1 = new Player("Steven");
        Player player2 = new Player("Petr");
        Player player3 = new Player("Robert");
        Player player4 = new Player("Joe");

        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
                Thread.sleep(500);
                player1.endBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
                Thread.sleep(3000);
                player2.endBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
                Thread.sleep(3000);
                player3.endBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                player4.startBattle(boss);
                Thread.sleep(3000);
                player4.endBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
