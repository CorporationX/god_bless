package school.faang.supercow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(2);

        Player player1 = new Player("Simon");
        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Player player2 = new Player("Dimon");
        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();

        Player player3 = new Player("Limon");
        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();

        Player player4 = new Player("Bimon");
        Thread thread4 = new Thread(() -> {
            try {
                player4.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread4.start();
    }
}
