package school.faang.sprint3.task6;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
