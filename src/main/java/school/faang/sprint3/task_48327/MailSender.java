package school.faang.sprint3.task_48327;

public class MailSender {
    private static final int NUM_OF_MESSAGES = 1000;
    private static final int NUM_OF_THREADS = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_OF_THREADS];

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            threads[i] = new Thread(
                    new SenderRunnable(i * NUM_OF_MESSAGES / NUM_OF_THREADS, (i + 1) * NUM_OF_MESSAGES / NUM_OF_THREADS)
            );
            threads[i].start();
        }

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("All the %d messages have been sent successfully !", NUM_OF_MESSAGES);
    }
}
