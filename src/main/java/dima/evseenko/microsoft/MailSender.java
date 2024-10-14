package dima.evseenko.microsoft;

public class MailSender {
    public void send() {
        for (int i = 0; i < 5; i++) {
            new Thread(new SenderRunnable(i * 200, (i + 1) * 200)).start();
        }
    }
}
