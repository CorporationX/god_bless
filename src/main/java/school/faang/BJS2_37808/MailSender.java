package school.faang.BJS2_37808;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все письма отправлены!");
    }
}
