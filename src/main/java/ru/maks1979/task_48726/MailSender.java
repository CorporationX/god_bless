package ru.maks1979.task_48726;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable firstSender = new SenderRunnable(1, 200);
        Thread thread1 = new Thread(firstSender);
        thread1.start();
        SenderRunnable secondSender = new SenderRunnable(201, 400);
        Thread thread2 = new Thread(secondSender);
        thread2.start();
        SenderRunnable thirdSender = new SenderRunnable(401, 600);
        Thread thread3 = new Thread(thirdSender);
        thread3.start();
        SenderRunnable fourthSender = new SenderRunnable(601, 800);
        Thread thread4 = new Thread(fourthSender);
        thread4.start();
        SenderRunnable fifthSender = new SenderRunnable(801, 1000);
        Thread thread5 = new Thread(fifthSender);
        thread5.start();
        try {
            thread1.join();
            System.out.println("Главный поток дождался завершения Потока 1.");
            thread2.join();
            System.out.println("Главный поток дождался завершения Потока 2.");
            thread3.join();
            System.out.println("Главный поток дождался завершения Потока 3.");
            thread4.join();
            System.out.println("Главный поток дождался завершения Потока 4.");
            thread5.join();
            System.out.println("Главный поток дождался завершения Потока 5.");
        } catch (InterruptedException e) {
            System.out.println("Отправка писем успешно завершена.");
        }
    }
}
