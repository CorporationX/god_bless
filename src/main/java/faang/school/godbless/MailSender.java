package faang.school.godbless;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(i * 200 + 1, (i + 1) * 200);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            thread.join();
        }

    }
}
