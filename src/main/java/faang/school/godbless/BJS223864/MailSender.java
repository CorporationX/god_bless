package faang.school.godbless.BJS223864;

public class MailSender {
    public static void main(String[] args) {
        // Параметризировать
        int totalMessages = 1000;
        int messagesPerThread = totalMessages / 5;

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * messagesPerThread + 1;
            int endIndex = startIndex + messagesPerThread - 1;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);

            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

        System.out.println("All messages sent!");
    }
}
