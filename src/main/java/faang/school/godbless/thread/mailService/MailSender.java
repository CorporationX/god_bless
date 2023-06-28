package faang.school.godbless.thread.mailService;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, startIndex + 200);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            thread.join();
        }
    }
}
