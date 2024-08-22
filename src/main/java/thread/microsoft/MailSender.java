package thread.microsoft;

public class MailSender {

    public static void main(String[] args) {

        int threadCount = 5;
        int mailsPerThread = 200;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * mailsPerThread;
            int endIndex = (i + 1) * mailsPerThread;
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(sender);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены.");
    }
}
