package school.faang.Sprints.Multithreading_Synchronization.bro_force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.5;
            threads[i] = new Thread(() -> game.update(earnedPoints, lostLife));
            threads[i].start();
        }

    }
}