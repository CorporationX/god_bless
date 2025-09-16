package bjs291065;

public class MailSender {
    private static final int MESSAGES_AMOUNT = 1000;
    private static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_AMOUNT];
        int mailsForThread = MESSAGES_AMOUNT / THREADS_AMOUNT;
        int startLetterNum = 1;
        int finishLetterNum = mailsForThread;

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            threads[i] = new Thread(new SenderRunnable(startLetterNum, finishLetterNum));
            startLetterNum += mailsForThread;
            finishLetterNum += mailsForThread;
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        System.out.println("All messages were sent!");
    }
}
