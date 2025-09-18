package school.faang.bjs2_91093;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable senderRunnable1 = new SenderRunnable(1, 200);
        SenderRunnable senderRunnable2 = new SenderRunnable(201, 400);
        SenderRunnable senderRunnable3 = new SenderRunnable(401, 600);
        SenderRunnable senderRunnable4 = new SenderRunnable(601, 800);
        SenderRunnable senderRunnable5 = new SenderRunnable(801, 1000);
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
        thread1.
        try {
            thread1.join();
            if (senderRunnable1.isPartOfMailsSent()) {
                System.out.println("Поток 1 успешно");
            }
            thread2.join();
            if (senderRunnable2.isPartOfMailsSent()) {
                System.out.println("Поток 2 успешно");
            }
            thread3.join();
            if (senderRunnable3.isPartOfMailsSent()) {
                System.out.println("Поток 3 успешно");
            }
            thread4.join();
            if (senderRunnable4.isPartOfMailsSent()) {
                System.out.println("Поток 4 успешно");
            }
            thread5.join();
            if (senderRunnable5.isPartOfMailsSent()) {
                System.out.println("Поток 5 успешно");
            }

            if (
                    senderRunnable1.isPartOfMailsSent() &&
                            senderRunnable2.isPartOfMailsSent() &&
                            senderRunnable3.isPartOfMailsSent() &&
                            senderRunnable4.isPartOfMailsSent() &&
                            senderRunnable5.isPartOfMailsSent() &&
            ) {
                System.out.println("");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Отправка прервана, завершаю всю отправку");
        }
    }
}
