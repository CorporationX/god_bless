package work.in.microsoft;

public class MailSender {
    private static final int MAILS_CHUNK = 200;
    private static final int THREAD_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < THREAD_SIZE; i++) {
            int startIndex = i * MAILS_CHUNK;
            Thread sentThread = new Thread(new SenderRunnable(startIndex, startIndex + MAILS_CHUNK));

            sentThread.start();
            sentThread.join();
        }
    }
}
