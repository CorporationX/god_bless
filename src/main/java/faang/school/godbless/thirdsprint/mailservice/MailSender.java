package faang.school.godbless.thirdsprint.mailservice;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int messagesPerThread = totalMessages / 5;

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = startIndex + messagesPerThread;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex), "Thread-" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All messages sent successfully!");
    }
}
