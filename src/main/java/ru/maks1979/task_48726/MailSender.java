package ru.maks1979.task_48726;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable firstSender = new SenderRunnable(1, 200);
        SenderRunnable secondSender = new SenderRunnable(201, 400);
        SenderRunnable thirdSender = new SenderRunnable(401, 600);
        SenderRunnable fourthSender = new SenderRunnable(601, 800);
        SenderRunnable fifthSender = new SenderRunnable(801, 1000);

        Thread thread1 = new Thread(firstSender);
        Thread thread2 = new Thread(secondSender);
        Thread thread3 = new Thread(thirdSender);
        Thread thread4 = new Thread(fourthSender);
        Thread thread5 = new Thread(fifthSender);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
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
