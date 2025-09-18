package school.faang.bjs2_91212;

public class MailSender {

    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int EMAIL_FOR_THREAD = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * EMAIL_FOR_THREAD + 1;
            int endIndex = (i + 1) * EMAIL_FOR_THREAD;

            SenderRunnable task = new SenderRunnable(startIndex, endIndex);

            Thread thread = new Thread(task, "Email Sender-" + (i + 1));

            threads[i] = thread;

            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println("Поток " + thread.getName() + " завершил работу");
            } catch (InterruptedException e) {
                System.out.println("Ожидание прервано для потока: " + thread.getName());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Все потоки завершили работу, письма отправлены!");
    }
}
