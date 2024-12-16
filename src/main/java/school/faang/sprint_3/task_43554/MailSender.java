package school.faang.sprint_3.task_43554;

public class MailSender {
    public static final int MESSAGES_NUMBER = 1000;
    public static final int THREADS_NUMBER = 5;
    public static final int BATCH_NUMBER = MESSAGES_NUMBER / THREADS_NUMBER;

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < THREADS_NUMBER; i++) {
            int start = i * BATCH_NUMBER;
            int end = (i + 1) * BATCH_NUMBER;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены!");
    }
}
