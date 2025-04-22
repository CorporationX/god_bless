package school.faang.microsoft;

public class MailSender {

    private static final int TOTAL_NUMBER_LETTERS = 1000;
    private static final int TOTAL_COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        int countLettersForOneThread = TOTAL_NUMBER_LETTERS / TOTAL_COUNT_THREAD;
        Thread[] threads = new Thread[TOTAL_COUNT_THREAD];

        for (int i = 0; i < TOTAL_COUNT_THREAD; i++) {
            int startIndex = i * countLettersForOneThread;
            int endIndex = (i + 1) * countLettersForOneThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            System.out.println("Все сообщения отправлены");
            thread.join();
        }
    }
}
