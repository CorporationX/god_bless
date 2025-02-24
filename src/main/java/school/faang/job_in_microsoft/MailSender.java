package school.faang.job_in_microsoft;

public class MailSender {

    public static void main(String[] args) {
        SenderRunnable sender1 = new SenderRunnable(1, 200);
        Thread firstThread = new Thread(sender1);
        firstThread.start();
        SenderRunnable sender2 = new SenderRunnable(201, 400);
        Thread secondThread = new Thread(sender2);
        secondThread.start();
        SenderRunnable sender3 = new SenderRunnable(401, 600);
        Thread thirdThread = new Thread(sender3);
        thirdThread.start();
        SenderRunnable sender4 = new SenderRunnable(601, 800);
        Thread fourthThread = new Thread(sender4);
        fourthThread.start();
        SenderRunnable sender5 = new SenderRunnable(801, 1000);
        Thread fifthThread = new Thread(sender5);
        fifthThread.start();
    }
}
