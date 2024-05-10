package faang.school.godbless.multithreading_synchronization.BJS2_6506;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread thread1 = new Thread(() -> new Player("Player 1").startBattle(boss));
        Thread thread2 = new Thread(() -> new Player("Player 2").startBattle(boss));
        Thread thread3 = new Thread(() -> new Player("Player 3").startBattle(boss));
        Thread thread4 = new Thread(() -> new Player("Player 4").startBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException exception) {
            System.out.println("Main thread was interrupted. " + exception);
        }
    }
}
