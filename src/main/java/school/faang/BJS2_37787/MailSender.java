package school.faang.BJS2_37787;

public class MailSender {
    public static void main(String[] args) {
        int messages = 1000;
        int threadsCount = 5;
        int threadSize = messages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * threadSize;
            int endIndex = Math.min((i + 1) * threadSize, messages);

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены");
    }
}
