package faang.school.godbless.Microsoft;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable secondSender = new SenderRunnable(0, 200);
        SenderRunnable thirdSender = new SenderRunnable(200, 400);
        SenderRunnable fourthSender = new SenderRunnable(400, 600);
        SenderRunnable fifthSender = new SenderRunnable(600, 800);
        SenderRunnable sixthSender = new SenderRunnable(800, 1000);
        Thread firstThread = new Thread(secondSender);
        Thread secondThread = new Thread(thirdSender);
        Thread thirdThread = new Thread(fourthSender);
        Thread fourthThread = new Thread(fifthSender);
        Thread fifthThread = new Thread(sixthSender);
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();
        try {
            fifthThread.join();
            secondThread.join();
            thirdThread.join();
            fourthThread.join();
            fifthThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Письма отправлены");
    }
}
