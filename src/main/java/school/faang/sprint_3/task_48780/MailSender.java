package school.faang.sprint_3.task_48780;

public class MailSender {
    public static final int TOTAL_MESSAGES = 1000;
    public static final int THREADS_COUNT = 5;
    public static final int BATCH_SIZE = TOTAL_MESSAGES / THREADS_COUNT;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * BATCH_SIZE;
            int end = (i + 1) * BATCH_SIZE;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при отправке писем");
            }
        }

        System.out.println("Все письма отправлены!");
    }
}
