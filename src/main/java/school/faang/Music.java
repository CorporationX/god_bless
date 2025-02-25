package school.faang;

import java.util.Random;

public class Music {
    private static final int THREADS_AMOUNT = 5;
    private static final int OPERATIONS_AMOUNT = 4;
    private static final Random random = new Random();
    private static final Player player = new Player();

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_AMOUNT];

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            int randomOperation = random.nextInt(0, OPERATIONS_AMOUNT) + 1;
            switch (randomOperation) {
                case 1: threads[i] = new Thread(player::play);
                break;
                case 2: threads[i] = new Thread(player::pause);
                break;
                case 3: threads[i] = new Thread(player::skip);
                break;
                case 4: threads[i] = new Thread(player::previous);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomOperation);
            }
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

