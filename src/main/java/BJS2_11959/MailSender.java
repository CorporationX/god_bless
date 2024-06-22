package BJS2_11959;

public class MailSender {
    static final int EMAIL = 1000;
    public static void main(String[] args) {

        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            SenderRunnable senderRunnable  = new SenderRunnable(startIndex, EMAIL);
            Thread thread = new Thread(senderRunnable);
            thread.start();
        }
    }
}
