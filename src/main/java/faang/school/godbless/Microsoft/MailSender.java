package faang.school.godbless.Microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SenderRunnable(1, 3));
        Thread thread2 = new Thread(new SenderRunnable(4, 6));
        Thread thread3 = new Thread(new SenderRunnable(7, 9));
        Thread thread4 = new Thread(new SenderRunnable(10, 11));
        Thread thread5 = new Thread(new SenderRunnable(12, 13));
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
        System.out.println("Все сообщения отправлены");
    }
}
