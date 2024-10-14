package workInMicrosoft;

public class MailSender {
    private static int allMessage = 1000;
    private static int threadAmount = 5;
    private static int batchSize = allMessage / threadAmount;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[threadAmount];
        for (int i = 0; i < threadAmount; i++) {
            Thread thread = new Thread(new SenderRunnable((i * batchSize) + 1, ((i + 1) * batchSize) + 1));
            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все письма отправлены!");
    }
}
