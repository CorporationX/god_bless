package school.faang.thread1;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int totalMessages = 1000;
        int threadCount = 5;
        int batchSize = totalMessages / threadCount;

        Thread[] mailSenderThreads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            mailSenderThreads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            mailSenderThreads[i].start();
        }

        for (Thread thread : mailSenderThreads) {
            thread.join();
        }

        System.out.println("All the letters have been sent succesfully");
    }

}
