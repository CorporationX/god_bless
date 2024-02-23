package faang.school.godbless.youworkformicrosoft;

public class MailSender {
    public static void main(String... args) {
        Thread firstThread = new Thread(new SenderRunnable(0, 200));
        Thread secondThread = new Thread(new SenderRunnable(201, 400));
        Thread thirdThread = new Thread(new SenderRunnable(401, 600));
        Thread fourthThread = new Thread(new SenderRunnable(601, 800));
        Thread lastThread = new Thread(new SenderRunnable(801, 1000));

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        lastThread.start();
        try {
            firstThread.join();
            System.out.println("1 Поток завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            secondThread.join();
            System.out.println("2 Поток завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thirdThread.join();
            System.out.println("3 Поток завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            fourthThread.join();
            System.out.println("4 Поток завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            lastThread.join();
            System.out.println("5 Поток завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
