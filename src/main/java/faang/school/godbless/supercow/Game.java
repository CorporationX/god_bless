package faang.school.godbless.supercow;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss();

        Player player1 = new Player("Tom");
        Player player2 = new Player("Jack");
        Player player3 = new Player("Bob");
        Player player4 = new Player("Sam");

        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println("Player 1 interrupted");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println("Player 2 interrupted");
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println("Player 3 interrupted");
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                player4.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println("Player 4 interrupted");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println("The battle has ended!!!");
    }
}
