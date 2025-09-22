package school.faang.bjs2_91177;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable pack1 = new SenderRunnable(0, 200);
        SenderRunnable pack2 = new SenderRunnable(200, 400);
        SenderRunnable pack3 = new SenderRunnable(400, 600);
        SenderRunnable pack4 = new SenderRunnable(600, 800);
        SenderRunnable pack5 = new SenderRunnable(800, 1000);

        Thread thread1 = new Thread(pack1);
        Thread thread2 = new Thread(pack2);
        Thread thread3 = new Thread(pack3);
        Thread thread4 = new Thread(pack4);
        Thread thread5 = new Thread(pack5);

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
            System.out.println("Письма отправлены.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
