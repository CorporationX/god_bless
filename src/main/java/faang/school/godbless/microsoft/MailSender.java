package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int allMessages = 1000;
        int threadsCount = 5;
        int messagesPer1Thread = allMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = (i * messagesPer1Thread) + 1;
            int endIndex = (i + 1) * messagesPer1Thread;
            if (i == threadsCount - 1) {
                endIndex = allMessages;
            }

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All messages sent out");
    }
}
