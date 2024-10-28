package school.faang.sprint_3.microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new SenderRunnable(1, 200));
        Thread secondThread = new Thread(new SenderRunnable(201, 400));
        Thread thirdThread = new Thread(new SenderRunnable(401, 600));
        Thread fourthThread = new Thread(new SenderRunnable(601, 800));
        Thread fifthThread = new Thread(new SenderRunnable(801, 1000));

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();
        fourthThread.join();
        fifthThread.join();

        System.out.println("Отправка писем завершена");
    }
}
