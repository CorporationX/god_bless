package superCow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(8);
        Player player1 = new Player("иван");
        Player player2 = new Player("Макс");
        Player player3 = new Player("Георгий");
        Player player4 = new Player("Самюэль");

        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                player4.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
