package faang.school.godbless.BJS223589;

public class MailSender {
    private static final int POOL_THREAD = 5;
    private static final int TOTAL_MESSAGES = 200;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < POOL_THREAD; i++) {
            int startIndex = i * TOTAL_MESSAGES + 1;
            int endIndex = startIndex + TOTAL_MESSAGES - 1;
            Thread thread = new Thread(() -> {
                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                senderRunnable.run();
            });
            thread.start();
            thread.join();
            System.out.println(thread.getName() + " завершен.");
        }
    }
}