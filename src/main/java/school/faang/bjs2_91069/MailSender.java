package school.faang.bjs2_91069;

public class MailSender {
    private static final int MAILS_QUANTITY = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = MAILS_QUANTITY / 5;
        Thread[] sendersThreads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            sendersThreads[i] = new Thread(new SenderRunnable(start, end));
            sendersThreads[i].start();
        }

        for (Thread senderThread : sendersThreads) {
            senderThread.join();
        }

        System.out.println("Все письма были отправлены!");
    }
}
