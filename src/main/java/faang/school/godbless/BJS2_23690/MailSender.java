package faang.school.godbless.BJS2_23690;

public class MailSender {
    static final int BATCH_SIZE = 200;
    static final int THREAD_COUNT = 5;

    public static void main(String[] args) {

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = startIndex + BATCH_SIZE - 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex) {
            });

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
