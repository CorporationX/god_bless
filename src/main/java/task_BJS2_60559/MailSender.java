package task_BJS2_60559;

public class MailSender {
    private static final int THREAD_QUANTITY = 5;
    private static final int MAIL_QUANTITY = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_QUANTITY];
        int batchSize = MAIL_QUANTITY / THREAD_QUANTITY;

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            int start = i * batchSize + 1;
            int end = (i + 1) * batchSize + 1;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            threads[i].join();
        }

        System.out.println("Все письма отправлены!");
    }
}
