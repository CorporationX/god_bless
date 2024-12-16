package school.faang.bjs248245;

public class MailSender {
    public static void main(String[] args) {

        int allMsgCount = 1000;
        int threadsCount = 5;
        int messagesPerThread = allMsgCount / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * messagesPerThread + 1;
            int endIndex = (i == threadsCount - 1) ? allMsgCount : startIndex + messagesPerThread - 1;

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

        System.out.println("All messages have sent");
    }
}
