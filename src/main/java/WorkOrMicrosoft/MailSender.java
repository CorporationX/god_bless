package WorkOrMicrosoft;

public class MailSender {
    private static final int TOTAL_MESSAGE = 1000;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args)  {
        try {
            int size = TOTAL_MESSAGE / COUNT_THREAD;

            Thread[] threads = new Thread[COUNT_THREAD];

            for (int i = 0; i < COUNT_THREAD; i++) {
                int start = i * size;
                int end = (i + 1) * size;
                threads[i] = new Thread(new SenderRunnable(start, end));
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            System.out.println("All messages have been sent");
        } catch (InterruptedException e) {
            System.out.println("Error. Program execution was interrupted");
            e.printStackTrace();
        }

    }
}
