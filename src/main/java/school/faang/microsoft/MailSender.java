package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable sender1 = new SenderRunnable(1, 1, 200);
        Thread thread1 = new Thread(sender1);
        thread1.start();

        SenderRunnable sender2 = new SenderRunnable(2, 201, 400);
        Thread thread2 = new Thread(sender2);
        thread2.start();

        SenderRunnable sender3 = new SenderRunnable(3, 401, 600);
        Thread thread3 = new Thread(sender3);
        thread3.start();

        SenderRunnable sender4 = new SenderRunnable(4, 601, 800);
        Thread thread4 = new Thread(sender4);
        thread4.start();

        SenderRunnable sender5 = new SenderRunnable(5, 801, 1000);
        Thread thread5 = new Thread(sender5);
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
