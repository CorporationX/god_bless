package school.faang.sprint3.task_bjs248519;

public class MailSender {

    public static final int NUMBER_OF_TREADS = 5;
    public static final int MAIL_SEND_PER_ONE_THREAD = 200;

    public static void main(String[] args) {
        int start = 1;
        Thread[] threads = new Thread[NUMBER_OF_TREADS];
        SenderRunnable senderRunnable;

        for (int i = 0; i < NUMBER_OF_TREADS; i++) {
            senderRunnable = new SenderRunnable(start, start + MAIL_SEND_PER_ONE_THREAD - 1);
            threads[i] = new Thread(senderRunnable);
            start += MAIL_SEND_PER_ONE_THREAD;
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Ошибка ожидания завершения потока: " + thread.getName());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все письма отправлены!");
    }
}
