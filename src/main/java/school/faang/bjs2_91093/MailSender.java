package school.faang.bjs2_91093;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable senderRunnable1 = new SenderRunnable(1, 200);
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

        SenderRunnable senderRunnable5 = new SenderRunnable(801, 1000);
        Thread thread5 = new Thread(senderRunnable5);
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            if (senderRunnable1.isPartOfMailsSent()) {
                System.out.println("Поток 1 успешно");
            }
            if (senderRunnable2.isPartOfMailsSent()) {
                System.out.println("Поток 2 успешно");
            }
            if (senderRunnable3.isPartOfMailsSent()) {
                System.out.println("Поток 3 успешно");
            }
            if (senderRunnable4.isPartOfMailsSent()) {
                System.out.println("Поток 4 успешно");
            }
            if (senderRunnable5.isPartOfMailsSent()) {
                System.out.println("Поток 5 успешно");
            }

            if (
                    senderRunnable1.isPartOfMailsSent()
                            && senderRunnable2.isPartOfMailsSent()
                            && senderRunnable3.isPartOfMailsSent()
                            && senderRunnable4.isPartOfMailsSent()
                            && senderRunnable5.isPartOfMailsSent()
            ) {
                System.out.println("Все потоки успешно обработаны и отправили свои письма");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Отправка прервана, завершаю всю операцию");
        }
    }
}
