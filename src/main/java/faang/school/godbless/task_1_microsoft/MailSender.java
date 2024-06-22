package faang.school.godbless.task_1_microsoft;

public class MailSender {
    public static final int MAX_THREAD = 5;
    public static final int MAIL_LIMIT = 200;
    public static final int MAIL_AMOUNT = 1000;
    public static final String MSG_ERROR = "Основной поток был прерван.";
    public static final String MSG_SUCCESS = "Сообщения отправлены.";

    public static void main(String[] args) {
        Thread[] threads = createThreads();

        try {
            startThreads(threads);
        } catch (InterruptedException e) {
            throw new RuntimeException(MSG_ERROR);
        }
        System.out.println(MSG_SUCCESS);
    }

    private static void startThreads(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < MAX_THREAD; i++) {
            threads[i].start();
        }

        threads[0].join();
        threads[1].join();
        threads[2].join();
        threads[3].join();
        threads[4].join();
    }

    private static Thread[] createThreads() {
        int mailIndex = 1;

        Thread[] threads = new Thread[MAX_THREAD];
        for (int i = 0; i < MAX_THREAD; i++) {
            if (mailIndex + MAIL_LIMIT >= MAIL_AMOUNT) {
                threads[i] = new Thread(new SenderRunnable(mailIndex, MAIL_AMOUNT));
            } else {
                threads[i] = new Thread(new SenderRunnable(mailIndex, mailIndex + MAIL_LIMIT - 1));
            }
            mailIndex += MAIL_LIMIT;
        }

        return threads;
    }

}
