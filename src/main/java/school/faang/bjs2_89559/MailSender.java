package school.faang.bjs2_89559;

public class MailSender {

    public static final int currentLetterQuantity = 1000;
    public static final int threadQuantity = 5;
    public static final int batchSize = currentLetterQuantity / threadQuantity;

    public static void main(String[] args) {
        Thread[] threads = new Thread[threadQuantity];

        for (int i = 0; i < threadQuantity; i++) {
            threads[i] = new Thread(new SenderRunnable(i * batchSize, ((i + 1) * batchSize) - 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все письма были разосланы!");
    }
}