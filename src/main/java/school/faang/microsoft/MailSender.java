package school.faang.microsoft;

import lombok.SneakyThrows;

public class MailSender {
    private static final int MESSAGES_NUMBER = 1000;
    private static final int THREADS_NUMBER = 5;

    @SneakyThrows
    public static void main(String[] args) {
        int batch_size = MESSAGES_NUMBER / THREADS_NUMBER;
        Thread[] threads = new Thread[THREADS_NUMBER];

        for (int i = 0; i < THREADS_NUMBER; i++) {
            int start = i * batch_size;
            int end = (i + 1) * batch_size;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All the threads completed their work.");
    }
}