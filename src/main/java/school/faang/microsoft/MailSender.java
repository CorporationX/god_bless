package school.faang.microsoft;

public class MailSender {
    private static final int THREADS_COUNT = 5;
    private static final int MAILS_COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        int batch_size = MAILS_COUNT / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batch_size;
            int end = (i + 1) * batch_size;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.printf("All letters were send ");
    }
}
