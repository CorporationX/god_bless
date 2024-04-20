package faang.school.godbless.microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = i * startIndex + 100 ;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            thread.join();
        }
    }
}
