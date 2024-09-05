package faang.school.godbless.multithreading.synch.cow;

public class Battle {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player firstPlayer = new Player("First");
        Player secondPlayer = new Player("Second");
        Player thirdPlayer = new Player("Third");

        Thread firstThread = new Thread(() -> firstPlayer.startBattle(boss));
        Thread secondThread = new Thread(() -> secondPlayer.startBattle(boss));
        Thread thirdThread = new Thread(() -> thirdPlayer.startBattle(boss));

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        try {
            firstThread.join();
            secondThread.join();
            thirdThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
