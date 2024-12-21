package school.faang.task_48108;

public class MailSender {
    public static final int THREAD_PULL_SIZE = 5;
    public static final int MAX_EMAIL_NUMBER = 1000;
    public static final int EMAIL_SENDER_TIME = 100;

    public static void main(String[] args) {
        int emailSizeForThread = MAX_EMAIL_NUMBER / THREAD_PULL_SIZE;
        Thread[] threads = new Thread[THREAD_PULL_SIZE];
        System.out.println("Начинаем отправлять письма: ");

        for (int i = 0; i < THREAD_PULL_SIZE; i++) {
            int startIndex = emailSizeForThread * i;
            int stopIndex = emailSizeForThread * (i + 1);
            threads[i] = new Thread(new SenderRunnable(startIndex, stopIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все письма отправлены!");
    }
}
