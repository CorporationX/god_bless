package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(7,3);
        Player player1 = new Player("Den");
        Player player2 = new Player("John");
        Player player3 = new Player("Bob");
        Player player4 = new Player("Greg");
        Player player5 = new Player("Kate");
        Player player6 = new Player("Ben");

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

        Thread thread5 = new Thread(() -> {
            try {
                player5.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                player6.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
