package school.faang.bjs2_72912;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        SenderRunnable senderRunnable1 = new SenderRunnable(1, 200);
        SenderRunnable senderRunnable2 = new SenderRunnable(201, 400);
        SenderRunnable senderRunnable3 = new SenderRunnable(401, 600);
        SenderRunnable senderRunnable4 = new SenderRunnable(601, 800);
        SenderRunnable senderRunnable5 = new SenderRunnable(801, 1000);

        System.out.println("Every mail sent");
    }
}
