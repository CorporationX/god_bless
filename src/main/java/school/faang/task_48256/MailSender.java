package school.faang.task_48256;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new SenderRunnable(1, 10));
        final Thread thread2 = new Thread(new SenderRunnable(11, 20));
        final Thread thread3 = new Thread(new SenderRunnable(21, 30));
        final Thread thread4 = new Thread(new SenderRunnable(31, 40));
        final Thread thread5 = new Thread(new SenderRunnable(41, 50));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println("All five threads have finished. Main thread");
    }
}