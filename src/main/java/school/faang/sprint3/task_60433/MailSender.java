package school.faang.sprint3.task_60433;

public class MailSender {
    private static final int MESSAGE_COUNT = 10;
    private static final int THREADS_COUNT = 3;

    public static void main(String[] args) {
        int batchSize = MESSAGE_COUNT / THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = batchSize * i;
            int endIndex = (i == threads.length - 1) ? MESSAGE_COUNT : batchSize * (i + 1);
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex, MESSAGE_COUNT));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted " + thread.getName(), e);
            }
        }

        System.out.println("All messages have been sent!");
    }
}
