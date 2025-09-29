package school.faang.bjs2_91222;

import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        Thread sender1 = new Thread(new SenderRunnable(0, 200));
        Thread sender2 = new Thread(new SenderRunnable(200, 400));
        Thread sender3 = new Thread(new SenderRunnable(400, 600));
        Thread sender4 = new Thread(new SenderRunnable(600, 800));
        Thread sender5 = new Thread(new SenderRunnable(800, 1000));

        List<Thread> senders = List.of(sender1, sender2, sender3, sender4, sender5);
        for (Thread s : senders) {
            s.start();
        }
        for (Thread s : senders) {
            try {
                s.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("\n" + "Cообщения успешно отправлены!");
    }
}