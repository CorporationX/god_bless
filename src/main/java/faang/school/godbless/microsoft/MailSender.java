package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            var startIndex = i * 200 + 1;
            var endIndex = startIndex + 200;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            var thread = new Thread(senderRunnable);
            thread.start();
            thread.join();
        }
        System.out.println("All letters are have sent");

    }
}
