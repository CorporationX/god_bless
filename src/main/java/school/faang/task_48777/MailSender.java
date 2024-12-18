package school.faang.task_48777;


public class MailSender {
    public static void main(String[] args) {

        final int countThread = 5;
        final int batchSize = 200;

        Thread[] threads = new Thread[countThread];

        for (int i = 0; i < countThread; i++) {
            threads[i] = new Thread(new SenderRunnable(i * batchSize + 1, (i + 1) * batchSize));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
