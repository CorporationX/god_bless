package school.faang.module3.microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SenderRunnable(1, 200));
        thread1.start();
        Thread thread2 = new Thread(new SenderRunnable(201, 400));
        thread2.start();
        Thread thread3 = new Thread(new SenderRunnable(401, 600));
        thread3.start();
        Thread thread4 = new Thread(new SenderRunnable(601, 800));
        thread4.start();
        Thread thread5 = new Thread(new SenderRunnable(801, 1000));
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

            System.out.println("Все письма доставлены");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Письма не были отправлены! %s%n", e);
        }
    }
}
