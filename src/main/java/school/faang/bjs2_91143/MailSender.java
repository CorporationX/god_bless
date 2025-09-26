package school.faang.bjs2_91143;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable sr1 = new SenderRunnable(0, 200);
        Thread thr1 = new Thread(sr1);
        thr1.start();

        SenderRunnable sr2 = new SenderRunnable(200, 400);
        Thread thr2 = new Thread(sr2);
        thr2.start();

        SenderRunnable sr3 = new SenderRunnable(400, 600);
        Thread thr3 = new Thread(sr3);
        thr3.start();

        SenderRunnable sr4 = new SenderRunnable(600, 800);
        Thread thr4 = new Thread(sr4);
        thr4.start();

        SenderRunnable sr5 = new SenderRunnable(800, 1000);
        Thread thr5 = new Thread(sr5);
        thr5.start();

        try {
            thr1.join();
            thr2.join();
            thr3.join();
            thr4.join();
            thr5.join();
            System.out.println("Все сообщения успешно отправлены");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            System.out.println("Поток был прерван");
        }
        System.out.println("Основной поток завершил работу");
    }
}
