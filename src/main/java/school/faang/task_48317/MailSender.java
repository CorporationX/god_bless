package school.faang.task_48317;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int emailToSent = 1000;
        int portion = 199;
        for (int i = 1; i <= emailToSent; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(i, i + portion);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            i += portion;
            thread.join();
        }
        System.out.println("All emails sent");
    }
}
