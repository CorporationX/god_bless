package school.faang.bjs2_89585;

@SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
public class MailSender {
    public static void main(String[] args) {
        final int THREAD_COUNT = 5;
        final int TOTAL_MESSAGES = 1000;
        int batchSize = TOTAL_MESSAGES / THREAD_COUNT;
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize - 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток main не смог дождаться, его прервали.");
            }
        }
        System.out.println("Все письма разосланы.");
    }
}
