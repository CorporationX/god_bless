package school.faang.bjs2_81261;

public class MailSender {
    private static final int LETTERS = 1000;
    private static final int THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        final int batch_size = LETTERS / THREADS;

        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            int start = i * batch_size;
            int end = (i + 1) * batch_size;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("all letters sent");
    }
}

