package mod1sp12.workInMicrosoft;

public class MailSender {
    private static int allMessage = 1000;
    private static int threadAmount = 5;
    private static int batchSize = allMessage / threadAmount;

    public static void main(String[] args) {
        Thread[] threads = new Thread[threadAmount];
        for (int i = 0; i < threadAmount; i++) {
            Thread thread = new Thread(new SenderRunnable((i * batchSize) + 1, ((i + 1) * batchSize)));
            threads[i] = thread;
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("join() method has not completed his work");
        }

        System.out.println("Все письма отправлены!");
    }
}
