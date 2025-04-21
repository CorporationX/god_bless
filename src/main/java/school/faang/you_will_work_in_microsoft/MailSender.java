package school.faang.you_will_work_in_microsoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT =5;

    public static void main (String[] args) throws InterruptedException {
        int bachSize = TOTAL_MESSAGES/THREADS_COUNT;

        Thread [] treads = new Thread[5];

        for (int i =0; i < 5; i++) {

        }
    }
}
