package bjs2_72793;

public class MailSender {
    private static final int MAXIMUM_NUMBER_OF_EMAILS_PER_STREAM = 200;
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i<NUMBER_OF_THREADS; i++){
            int start = i * MAXIMUM_NUMBER_OF_EMAILS_PER_STREAM;
            int end = start + MAXIMUM_NUMBER_OF_EMAILS_PER_STREAM;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println("All messages have been sent!");
    }
}
