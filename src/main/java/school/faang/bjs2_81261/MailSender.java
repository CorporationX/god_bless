package school.faang.bjs2_81261;

public class MailSender {
    private static final int LETTERS = 1000;
    private static final int THREADS = 5;
    private static final int BATCH_SIZE = LETTERS / THREADS;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            int start = i * BATCH_SIZE;
            int end = (i + 1) * BATCH_SIZE;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("all letters sent");
    }
}