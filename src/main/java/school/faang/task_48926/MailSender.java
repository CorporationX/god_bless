package school.faang.task_48926;

public class MailSender {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new SenderRunnable(0, 199));
        thread1.start();
        Thread thread2 = new Thread(new SenderRunnable(200, 399));
        thread2.start();
        Thread thread3 = new Thread(new SenderRunnable(400, 599));
        thread3.start();
        Thread thread4 = new Thread(new SenderRunnable(600, 799));
        thread4.start();
        Thread thread5 = new Thread(new SenderRunnable(800, 999));
        thread5.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() != null ? e.getMessage() : "Поток был прерван.");
        }

        System.out.println("******************************** Все письма отправлены ********************************");

    }
}
