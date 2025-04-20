package school.faang.bjs272715;

public class MailSender {
    private static short MESSAGES_COUNT = 200;
    private static byte THREADS_COUNT = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread(new SenderRunnable(i * MESSAGES_COUNT, (i + 1) * MESSAGES_COUNT));
            thread.start();
            threads[i] = thread;
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("All messages sent.");
    }
}
