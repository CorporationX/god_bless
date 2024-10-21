package school.faang.youworkmicrosoft;

public class MailSender {

    private static final int TOTAL_EMAILS = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int EMAILS_PER_THREAD = TOTAL_EMAILS / THREAD_COUNT;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * EMAILS_PER_THREAD + 1;
            int endIndex = startIndex + EMAILS_PER_THREAD - 1;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All emails have been sent successfully.");
    }
}
