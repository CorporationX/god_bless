package school.faang.bjs280861;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(0, 200);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            thread.join();
        }

        System.out.println("1000 Писем отправлены");


    }
}
