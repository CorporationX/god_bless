package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        SenderRunnable senderRunnable = new SenderRunnable(1, 200);

        var thread2 = new Thread(senderRunnable::run);
        thread2.start();

        SenderRunnable senderRunnable1 = new SenderRunnable(201, 400);

        var thread3 = new Thread(senderRunnable1::run);
        thread3.start();

        SenderRunnable senderRunnable2 = new SenderRunnable(401, 600);

        var thread4 = new Thread(senderRunnable2::run);
        thread4.start();

        SenderRunnable senderRunnable3 = new SenderRunnable(601, 800);

        var thread5 = new Thread(senderRunnable3::run);
        thread5.start();

        SenderRunnable senderRunnable4 = new SenderRunnable(801, 1000);
        senderRunnable4.run(); //main thread1

        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println("All messages were sent");
    }
}
