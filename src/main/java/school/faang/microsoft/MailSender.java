package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int countThread = 5;
        int batchSize = totalMessages / countThread;

        Thread[] threads = new Thread[countThread];
        for (int i = 0; i < countThread; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Отправка писем прервана...");
            }
        }
    }
}
