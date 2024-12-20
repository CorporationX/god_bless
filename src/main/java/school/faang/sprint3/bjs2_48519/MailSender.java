package school.faang.sprint3.bjs2_48519;

public class MailSender {

    public static final int NUMBER_OF_TREADS = 5;
    public static final int MAIL_SEND_PER_ONE_THREAD = 200;

    public static void main(String[] args) throws InterruptedException {
        int start = 1;
        Thread[] threads = new Thread[NUMBER_OF_TREADS];

        for (int i = 0; i < NUMBER_OF_TREADS; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(start, start + MAIL_SEND_PER_ONE_THREAD - 1);
            threads[i] = new Thread(senderRunnable);
            start += MAIL_SEND_PER_ONE_THREAD;
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
