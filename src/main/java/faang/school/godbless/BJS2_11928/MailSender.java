package faang.school.godbless.BJS2_11928;

public class MailSender {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;
            SenderRunnable senderRunnable =  new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();
        }

    }
}
