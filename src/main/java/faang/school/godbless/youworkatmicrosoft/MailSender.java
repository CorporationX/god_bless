package faang.school.godbless.youworkatmicrosoft;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int numThreads = 5;
        int messagesPerThread = totalMessages / numThreads;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * messagesPerThread;
            int end = (i + 1) * messagesPerThread;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All messages have been sent");
    }
}