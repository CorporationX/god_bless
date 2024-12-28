package school.faang.task49744;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player(" player 1");
        Player player2 = new Player(" player 2");
        Player player3 = new Player(" player 3");

        Thread thread1 = new Thread(() -> {

            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
