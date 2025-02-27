package school.faang.job_in_microsoft;

public class MailSender {

    public static final int MAILS_PER_THREAD = 200;
    public static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        int startIndex = 1;
        int endIndex = MAILS_PER_THREAD;
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        for (int i = 0; i < threads.length; i++) {
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(sender);
            threads[i] = thread;
            thread.start();
            thread.join();
            startIndex += MAILS_PER_THREAD;
            endIndex += MAILS_PER_THREAD;
        }
        System.out.println("Программа завершила свою работу");
    }
}
