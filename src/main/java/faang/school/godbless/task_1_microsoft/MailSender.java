package faang.school.godbless.task_1_microsoft;

public class MailSender {
    public static final int MAX_THREAD = 5;
    public static final int MAIL_LIMIT = 200;
    public static final int MAIL_AMOUNT = 1000;
    public static final String MSG_ERROR = "Основной поток был прерван.";
    public static final String MSG_CUCCESS = "Сообщения отправлены.";

    public static void main(String[] args) {
        int mailIndex = 1;

        Thread[] threads = new Thread[MAX_THREAD];
        for (int i = 0; i < MAX_THREAD; i++) {
            if(mailIndex + MAIL_LIMIT >= MAIL_AMOUNT){
                threads[i] = new Thread(new SenderRunnable(mailIndex, MAIL_AMOUNT));
            } else {
                threads[i] = new Thread(new SenderRunnable(mailIndex, mailIndex + MAIL_LIMIT - 1));
            }
            mailIndex += MAIL_LIMIT;
        }

        for (int i = 0; i < MAX_THREAD; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(MSG_ERROR);
            }
        }

        System.out.println(MSG_CUCCESS);
    }
}
