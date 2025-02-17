package school.faang.youworkinmicrosoft;

public class MailSender {
    private static final int TOTAL_MESSAGE = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {

        int averageNumberOfMessages = TOTAL_MESSAGE / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * averageNumberOfMessages;
            int end = (i + 1) * averageNumberOfMessages;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все потоки отработали!");
    }
}