package faang.school.godbless.parallelMailSender;

public class MailSender {
    public static final int MESSAGES_PER_THREAD = 200;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            SenderRunnable sender = new SenderRunnable(i * MESSAGES_PER_THREAD, (i + 1) * MESSAGES_PER_THREAD);
            threads[i] = new Thread(sender);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }

        System.out.println("All letters have been sent");
    }
}
