package school.BJS2_37751;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        SenderRunnable senderRunnable1 = new SenderRunnable(1,200);
        SenderRunnable senderRunnable2 = new SenderRunnable(1,200);
        SenderRunnable senderRunnable3 = new SenderRunnable(1,200);
        SenderRunnable senderRunnable4 = new SenderRunnable(1,200);
        SenderRunnable senderRunnable5 = new SenderRunnable(1,200);
        Thread thread1 = new Thread(senderRunnable1);
        Thread thread2 = new Thread(senderRunnable2);
        Thread thread3 = new Thread(senderRunnable3);
        Thread thread4 = new Thread(senderRunnable4);
        Thread thread5 = new Thread(senderRunnable5);
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
        System.out.println("Все письма отправлены");





    }




}
