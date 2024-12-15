package school.faang.sprint3.bjs_48265;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        SenderRunnable firstPartMails = new SenderRunnable(1, 200);
        Thread firstThread = new Thread(firstPartMails);
        firstThread.start();
        firstThread.join();

        SenderRunnable secondPartMails = new SenderRunnable(201, 400);
        Thread secondThread = new Thread(secondPartMails);
        secondThread.start();
        secondThread.join();

        SenderRunnable thirdPartMails = new SenderRunnable(401, 600);
        Thread thirdThread = new Thread(thirdPartMails);
        thirdThread.start();
        thirdThread.join();

        SenderRunnable fourthPartMails = new SenderRunnable(601, 800);
        Thread fourthThread = new Thread(fourthPartMails);
        fourthThread.start();
        fourthThread.join();

        SenderRunnable fifthPartMails = new SenderRunnable(801, 1000);
        Thread fifthThread = new Thread(fifthPartMails);
        fifthThread.start();
        fifthThread.join();

        System.out.println("Все письма успешно отправлены!");
    }
}
