package faang.school.godbless.BJS25683;

public class MailSender {
    public static void main(String[] args) {
        final int totalMessages = 1000;
        final int numThreads = 5;
        final int messagesPerThread = totalMessages / numThreads;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * messagesPerThread + 1;
            int endIndex = (i + 1) * messagesPerThread;
            if (i == numThreads - 1) {
                endIndex = totalMessages;
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

        System.out.println("Все сообщения успешно отправлены.");
    }
}
