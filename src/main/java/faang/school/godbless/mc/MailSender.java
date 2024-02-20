package faang.school.godbless.mc;

public class MailSender {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        int mailPerThread = 200;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = (i * mailPerThread) + 1;
            int endIndex = (i + 1) * mailPerThread;
            threads[i] = new Thread( new SenderRunnable( startIndex, endIndex ) );
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException( e );
            }
        }

        System.out.println( "All mails are sent!" );
    }
}

