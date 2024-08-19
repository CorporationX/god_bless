package faang.school.godbless.sprint.three.microsoft;

public class MailSender {
    public static void main(String... args) {
        int batchMails = Constants.MAILS_IN_QUEUE / Constants.ACTIVE_THREADS;

        int start = 1;
        int end;
        for (int i = 0; i < Constants.ACTIVE_THREADS; i++) {
            end = start + batchMails;

            SenderRunnable senderRunnable = new SenderRunnable(start, end);
            Thread thread = new Thread(senderRunnable);
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            start = end;
        }
    }
}
