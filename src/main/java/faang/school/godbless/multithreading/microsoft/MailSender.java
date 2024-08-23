package faang.school.godbless.multithreading.microsoft;

public class MailSender {

    private static final int MAILS_PER_THREAD = 200;
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            int startIndex = i * MAILS_PER_THREAD + 1;
            int endIndex = startIndex + MAILS_PER_THREAD;

            Thread thread = new Thread(() -> {
                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                senderRunnable.run();
            });

            thread.start();
            thread.join();

            System.out.printf("[%s] >>> --- >>> Thread Done <<< --- <<<\r\n", thread.getName());
        }

        System.out.println(" >>> >>> >>> All mails was sent <<< <<< <<< ");
    }

}