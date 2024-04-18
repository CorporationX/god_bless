package faang.school.godbless.microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            int end = 200 * i;
            int start = end - 199;
            SenderRunnable senderRunnable = new SenderRunnable(start, end);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            thread.join();
        }
    }
}
