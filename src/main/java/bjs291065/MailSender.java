package bjs291065;

public class MailSender {
    private static final int MESSAGES_AMOUNT = 1000;
    private static final int THREADS_AMOUNT = 5;
    private static final int MAILS_FOR_THREAD = MESSAGES_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_AMOUNT];
        int startLetterNum = 1;
        int finishLetterNum = MAILS_FOR_THREAD;

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            threads[i] = new Thread(new SenderRunnable(startLetterNum, finishLetterNum));
            startLetterNum += MAILS_FOR_THREAD;
            finishLetterNum += MAILS_FOR_THREAD;
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All messages were sent!");
    }
}
