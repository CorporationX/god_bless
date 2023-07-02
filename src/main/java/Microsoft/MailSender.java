package Microsoft;

public class MailSender {
    private static final Integer THREAD_CNT = 5;
    private static final Integer BATCH_SIZE = 100;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_CNT; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = startIndex + BATCH_SIZE - 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));

            thread.start();
            thread.join();
        }
    }
}
