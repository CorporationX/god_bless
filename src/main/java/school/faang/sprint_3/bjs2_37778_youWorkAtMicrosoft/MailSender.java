package school.faang.sprint_3.bjs2_37778_youWorkAtMicrosoft;

public class MailSender {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int totalMessages = 1000;

        int batchSize = totalMessages / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время ожидания завершения " + e.getMessage());
                thread.interrupt();
            }
        }

        System.out.println("Все письма отправлены!");
    }
}
