package faang.school.godbless.microsoft_outlook;

public class MailSender {

    public static void main(String[] args) {
        int totalMessages = 1000;
        int totalThreads = 5;
        int messagePerThread = totalMessages / totalThreads;
        Thread[] threads = new Thread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
            int startIndex = i * messagePerThread + 1;
            int endIndex = (i + 1) * messagePerThread;
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

        System.out.println("All messages have been send!");
    }
}
