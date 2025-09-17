package bjs2_91067;

public class MailSender {
    private static final int TOTAL_MAILS = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        final int batchSize = TOTAL_MAILS / THREAD_COUNT;

        Thread[] threads = new Thread[THREAD_COUNT];

        // Создаем и запускаем потоки
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize - 1;

            threads[i] = new Thread(new SenderRunnable(start, end), "Поток-" + (i + 1));
            threads[i].start();
        }

        // Ждём завершения всех потоков
        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("✅ Все письма успешно отправлены!");
    }
}