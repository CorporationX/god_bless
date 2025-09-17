package school.faang.multithreading_parallelism_thread.bgs2_91238;

import lombok.RequiredArgsConstructor;

import static java.util.concurrent.ThreadLocalRandom.current;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private static int RANDOM_TIME_LOWER_BOUND = 1;
    private static int RANDOM_TIME_UPPER_BOUND = 15;
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        if (startIndex >= endIndex) {
            return;
        }

        for (int mailLetterNumber = startIndex + 1;
             mailLetterNumber <= endIndex;
             mailLetterNumber++) {

            final int randomTime = current().nextInt(RANDOM_TIME_LOWER_BOUND,
                    RANDOM_TIME_UPPER_BOUND);
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.print(e.getMessage());
            }
            System.out.printf("Письмо № %d1 отправлено таймаут: %d2 \n", mailLetterNumber, randomTime);
        }
    }
}