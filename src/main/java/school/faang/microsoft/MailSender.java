package school.faang.microsoft;

public class MailSender {
    private static final int TOTAL_MESSAGE = 100;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        int sizeMessage = TOTAL_MESSAGE / COUNT_THREAD;

        Thread[] threads = new Thread[sizeMessage];

        for (int i = 0; i < sizeMessage; i++) {
            int start = i * sizeMessage;
            int finish = (i + 1) * sizeMessage;

            threads[i] = new Thread(new SenderRunnable(start, finish));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все сообщения отправлены");
    }
}
