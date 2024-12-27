package faang.school.godbless.sprint_3.task_49409;

import java.util.Random;

public class Music {

    private static final int NUMBER_OF_THREADS = 7;

    private static final int NUMBER_OF_PLAYER_METHODS = 4;

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Random random = new Random();

        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < threads.length; i++) {
            int methodNumber = random.nextInt(NUMBER_OF_PLAYER_METHODS);
            switch (methodNumber) {
                case (0):
                    threads[i] = new Thread(player::play);
                    break;
                case (1):
                    threads[i] = new Thread(player::pause);
                    break;
                case (2):
                    threads[i] = new Thread(player::skip);
                    break;
                case (3):
                    threads[i] = new Thread(player::previous);
                    break;
            }
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
