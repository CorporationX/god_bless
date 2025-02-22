package school.faang.threadmicrosoft;

public class MailSender {
    static final int AMOUNT_OF_THREADS = 5;
    static final int AMOUNT_OF_TASKS = 1000;

    public static void main(String[] args) throws InterruptedException {
        final int emailsPerThread = AMOUNT_OF_TASKS / AMOUNT_OF_THREADS;
        Thread[] threads = new Thread[AMOUNT_OF_THREADS];
        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            threads[i] = new Thread(new SenderRunnable(i * emailsPerThread, (i * emailsPerThread) + emailsPerThread));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }


}
