package school.faang.bjs2_91090;

public class MailSender {
    private static final int EMAIL_AMOUNT = 1000;
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_AMOUNT];
        int batchSize = EMAIL_AMOUNT / THREAD_AMOUNT;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SenderRunnable(i * batchSize + 1, (i + 1) * batchSize));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все сообщения отправлены!");
    }
}
