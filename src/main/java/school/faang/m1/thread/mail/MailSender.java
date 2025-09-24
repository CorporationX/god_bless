package school.faang.m1.thread.mail;

public class MailSender {

    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int CHUNK_SIZE = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) throws InterruptedException {

        Thread[] workers = new Thread[THREAD_COUNT];

        for (int t = 0; t < THREAD_COUNT; t++) {
            int start = t * CHUNK_SIZE;
            int end = (t == THREAD_COUNT - 1) ? TOTAL_MESSAGES : start + CHUNK_SIZE;

            SenderRunnable task = new SenderRunnable(start, end);
            workers[t] = new Thread(task, "Sender-" + (t + 1));
            workers[t].start();
        }

        for (Thread worker : workers) {
            worker.join();
        }

        System.out.println("All mails sent!");
    }
}
