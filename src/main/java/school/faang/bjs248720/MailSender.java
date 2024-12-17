package school.faang.bjs248720;

public class MailSender {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i+=200) {
            new Thread(new SenderRunnable(i + 1, i + 200)).start();
        }
    }
}
