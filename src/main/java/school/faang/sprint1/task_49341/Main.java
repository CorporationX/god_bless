package school.faang.sprint1.task_49341;

public class Main {
    public static void main(String[] args) {
        final int sumIterator = 100;
        final double changePoint = 0.5;
        final double changeLife = 0.7;

        Game game = new Game();


        for (int i = 0; i < sumIterator; i++) {
            boolean earnedPoints = Math.random() > changePoint;
            boolean lostLife = Math.random() > changeLife;

            Thread thread1 = new Thread(() -> game.update(earnedPoints, lostLife));
            Thread thread2 = new Thread(() -> game.update(earnedPoints, lostLife));

            thread1.start();
            thread2.start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
