package school.faang.bjs2_91090;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        final Thread firstThread = new Thread(new SenderRunnable(1, 200));
        final Thread secondThread = new Thread(new SenderRunnable(201, 400));
        final Thread thirdThread = new Thread(new SenderRunnable(401, 600));
        final Thread forthThread = new Thread(new SenderRunnable(601, 800));
        final Thread fifthThread = new Thread(new SenderRunnable(801, 1000));

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        forthThread.start();
        fifthThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();
        forthThread.join();
        fifthThread.join();

        System.out.println("Все сообщения отправлены!");
    }
}
