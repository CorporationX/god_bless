package school.faang.multithreading_parallelism_thread.bgs2_91238;

import lombok.AllArgsConstructor;

import static java.util.concurrent.ThreadLocalRandom.current;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
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

            final int randomTime = current().nextInt(1, 15);
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.print(e.getMessage());
            }
            System.out.print("Письмо № " + mailLetterNumber + " отправлено таймаут: " + randomTime + " \n");
        }
    }
}