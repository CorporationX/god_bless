package WorkInMicrosoft;

public class MailSender {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new SenderRunnable(1, 200));
        Thread secondThread = new Thread(new SenderRunnable(201, 400));
        Thread thirdThread = new Thread(new SenderRunnable(401, 600));
        Thread forthThread = new Thread(new SenderRunnable(601, 800));
        Thread fifthThread = new Thread(new SenderRunnable(801, 1000));

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        forthThread.start();
        fifthThread.start();
    }
}
