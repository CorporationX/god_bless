package multithreading.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        SenderRunnable sender1 = new SenderRunnable(1, 199);
        SenderRunnable sender2 = new SenderRunnable(200, 399);
        SenderRunnable sender3 = new SenderRunnable(400, 599);
        SenderRunnable sender4 = new SenderRunnable(600, 799);
        SenderRunnable sender5 = new SenderRunnable(800, 1000);

        Thread thread1 = new Thread(sender1);
        Thread thread2 = new Thread(sender2);
        Thread thread3 = new Thread(sender3);
        Thread thread4 = new Thread(sender4);
        Thread thread5 = new Thread(sender5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println("All message sent");

    }
}
