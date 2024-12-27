package school.faang.task_48909;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        SenderRunnable senderRunnable1 = new SenderRunnable(0, 200);
        Thread thread1 = new Thread(senderRunnable1);
        thread1.start();
        SenderRunnable senderRunnable2 = new SenderRunnable(201, 400);
        Thread thread2 = new Thread(senderRunnable2);
        thread2.start();
        SenderRunnable senderRunnable3 = new SenderRunnable(401, 600);
        Thread thread3 = new Thread(senderRunnable3);
        thread3.start();
        SenderRunnable senderRunnable4 = new SenderRunnable(601, 800);
        Thread thread4 = new Thread(senderRunnable4);
        thread4.start();
        SenderRunnable senderRunnable5 = new SenderRunnable(801, 100);
        Thread thread5 = new Thread(senderRunnable5);
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println("1000 messages was delivered");
    }
}