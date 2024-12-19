package school.faang.bjs248406;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SenderRunnable(1, 200));
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(new SenderRunnable(201, 400));
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(new SenderRunnable(401, 600));
        thread3.start();
        thread3.join();

        Thread thread4 = new Thread(new SenderRunnable(601, 800));
        thread4.start();
        thread4.join();

        Thread thread5 = new Thread(new SenderRunnable(801, 1000));
        thread5.start();
        thread5.join();

        System.out.println("The all letters is successfully sent");









    }
}
