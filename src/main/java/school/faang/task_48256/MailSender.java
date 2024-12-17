package school.faang.task_48256;

public class MailSender {
    public static void main(String[] args) {
        final int totalMessages = 1000;
        final int threads = 5;
        final int messagesThread = totalMessages / threads;

        final Thread[] totalThreads = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            int startIndex = i * messagesThread;
            int endIndex = (i + 1) * messagesThread;
            totalThreads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            totalThreads[i].start();
        }

        for (Thread thread : totalThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
            }
        }
        System.out.println("All messages have sent");
    }
}