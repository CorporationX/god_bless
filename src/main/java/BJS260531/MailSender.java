package BJS260531;

public class MailSender {
    private static final int MESSAGES = 1000;
    private static final  int THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = MESSAGES / THREADS;
        Thread[] threads = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Письма отправлены ");
    }


}
