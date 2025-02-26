package school.faang;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable firstThread = new SenderRunnable(0, 199);
        Thread newFirstThread = new Thread(firstThread);
        newFirstThread.start();
        SenderRunnable secodnThread = new SenderRunnable(200, 399);
        Thread newSecodnThread = new Thread(secodnThread);
        newSecodnThread.start();
        SenderRunnable thirdThread = new SenderRunnable(400, 599);
        Thread newThirdThread = new Thread(thirdThread);
        newThirdThread.start();
        SenderRunnable forthThread = new SenderRunnable(600, 799);
        Thread newForthThread = new Thread(forthThread);
        newForthThread.start();
        SenderRunnable fifthThread = new SenderRunnable(800, 999);
        Thread newFifthThread = new Thread(fifthThread);
        newFifthThread.start();
        try {
            newFirstThread.join();
            newSecodnThread.join();
            newThirdThread.join();
            newForthThread.join();
            newFifthThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все письма успешно отправлены");
    }
}
