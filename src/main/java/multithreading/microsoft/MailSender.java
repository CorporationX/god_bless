package multithreading.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int messageCount = 1000;
        int threadCount = 5;
        int batchSize = messageCount / threadCount;
        int batchStart = 1;
        while (messageCount > 0) {
            Thread thread = new Thread(new SenderRunnable(batchStart, batchStart + batchSize));
            batchStart += batchSize;
            messageCount -= batchSize;
            thread.start();
        }
    }
}
