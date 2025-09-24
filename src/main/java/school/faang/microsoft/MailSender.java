package school.faang.microsoft;

import java.util.concurrent.atomic.AtomicInteger;

public class MailSender {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger totalSent = new AtomicInteger(0);

        Thread thread = new Thread(new SenderRunnable(0, 200, totalSent));
        Thread thread2 = new Thread(new SenderRunnable(200, 400, totalSent));
        Thread thread3 = new Thread(new SenderRunnable(400, 600, totalSent));
        Thread thread4 = new Thread(new SenderRunnable(600, 800, totalSent));
        Thread thread5 = new Thread(new SenderRunnable(800, 1000, totalSent));

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println("Все письма отправлены ");
        System.out.println("Всего писем отправлено " + totalSent.get());
    }
}
