package school.faang.BJS2_37787;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int messages = 1000;
        int threadsCount = 5;
        int threadSize = messages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * threadSize;
            int endIndex = (i + 1) * threadSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
