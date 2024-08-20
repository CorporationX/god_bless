package faang.school.godbless.BJS2_23684;

public class MailSender {

    private static final int TOTAL_MESSAGE_COUNT = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int MESSAGE_TO_SEND_COUNT = TOTAL_MESSAGE_COUNT / THREAD_COUNT;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * MESSAGE_TO_SEND_COUNT + 1;
            int endIndex = startIndex + MESSAGE_TO_SEND_COUNT - 1;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            System.out.println("Thread " + i + " started");
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All messages sent");

    }
}
