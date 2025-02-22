package school.faang.microsoft;

public class MailSender {
    private static final int COUNT_OF_THREADS = 5;
    private static final int COUNT_OF_EMAILS = 1000;

    public static void main(String[] args) {

        Thread[] threads = new Thread[COUNT_OF_THREADS];
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            int startIndex = i * COUNT_OF_EMAILS / COUNT_OF_THREADS;
            int endIndex = startIndex + COUNT_OF_EMAILS / COUNT_OF_THREADS;
            threads[i] = new Thread(new SenderRunnable(startIndex + 1, endIndex));
        }

        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < COUNT_OF_THREADS; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("All emails sent");
    }
}
