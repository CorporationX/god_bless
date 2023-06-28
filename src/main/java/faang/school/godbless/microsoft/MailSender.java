package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SenderRunnable(0, 150));
        Thread thread2 = new Thread(new SenderRunnable(150, 350));
        Thread thread3 = new Thread(new SenderRunnable(350, 550));
        Thread thread4 = new Thread(new SenderRunnable(550, 650));
        Thread thread5 = new Thread(new SenderRunnable(650, 1000));


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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
