package school.faang.sender;

public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        int emailsPerThread = TOTAL_EMAILS / NUMBER_OF_THREADS;

        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = (i + 1) * emailsPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("Поток был прерван %s%n", e.getMessage());
            }
        }

        System.out.print("Все письма успешно отправлены!");
    }
}