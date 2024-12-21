package school.faang.sprint3task48692;

public class MailSender {
    private static final int POOL = 6;

    public static void main(String[] args) {
        int start = 0;

        for (int i = 1; i < POOL; i++) {
            SenderRunnable send = new SenderRunnable(start, start + 200);
            Thread thread = new Thread(send);
            thread.start();
            start += 200;
        }
    }
}