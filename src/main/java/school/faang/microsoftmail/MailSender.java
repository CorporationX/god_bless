package school.faang.microsoftmail;

public class MailSender {
    public static void main(String[] args) {
        final int COUNT_THREADS = 5;
        final int COUNT_LETTERS = 1000;

        int chunkSize = COUNT_LETTERS / COUNT_THREADS;
        Thread[] threadArray = new Thread[COUNT_THREADS];
        for (int i = 0; i < COUNT_LETTERS; i += chunkSize) {
            Thread newThread = new Thread(new SenderRunnable(i, i + chunkSize));
            threadArray[i / chunkSize] = newThread;
            newThread.start();
        }

        for (Thread senderRunnable : threadArray) {
            try {
                senderRunnable.join();
            } catch (InterruptedException e) {
                System.out.println("The flow was interrupted during sleep.");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("All letters were sent!");
    }
}
