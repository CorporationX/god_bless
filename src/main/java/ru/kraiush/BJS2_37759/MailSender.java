package ru.kraiush.BJS2_37759;

public class MailSender {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new SenderRunnable(1, 200));
        Thread thread2 = new Thread(new SenderRunnable(201, 400));
        Thread thread3 = new Thread(new SenderRunnable(401, 600));
        Thread thread4 = new Thread(new SenderRunnable(601, 800));
        Thread thread5 = new Thread(new SenderRunnable(801, 1000));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
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

        System.out.println("All emails were sent!");
    }
}
