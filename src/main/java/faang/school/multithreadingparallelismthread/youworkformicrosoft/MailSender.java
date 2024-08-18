package faang.school.multithreadingparallelismthread.youworkformicrosoft;


public class MailSender {

    private static final int COUNT_EMAILS_THREAD = 200;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) {

        Thread[] threads = new Thread[COUNT_THREAD];

        for (int i = 0; i < COUNT_THREAD; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(COUNT_EMAILS_THREAD * i + 1, COUNT_EMAILS_THREAD * i + 1 + COUNT_EMAILS_THREAD);

            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finish");

    }
}
