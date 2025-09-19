package school.faang.bjs2_90440;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Player player1 = new Player("Петя");
        Thread thread1 = new Thread(() -> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        Player player2 = new Player("Вася");
        Thread thread2 = new Thread(() -> {
            try {
                player2.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();
        Player player3 = new Player("Федя");
        Thread thread3 = new Thread(() -> {
            try {
                player3.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread3.start();
        Player player4 = new Player("Даша");
        Thread thread4 = new Thread(() -> {
            try {
                player4.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread4.start();
        Player player5 = new Player("Маша");
        Thread thread5 = new Thread(() -> {
            try {
                player5.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread5.start();
        Player player6 = new Player("Оля");
        Thread thread6 = new Thread(() -> {
            try {
                player6.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread6.start();
    }
}
