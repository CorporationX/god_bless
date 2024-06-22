package faang.school.godbless.sprint3.workInMicrosoft;


public class MailSender {

    public static void main(String[] args) {
        try {
            SenderRunnable senderRunnable = new SenderRunnable(0, 199);
            Thread thread1 = new Thread(senderRunnable);
            thread1.start();

            SenderRunnable senderRunnable2 = new SenderRunnable(200, 399);
            Thread thread2 = new Thread(senderRunnable2);
            thread2.start();

            SenderRunnable senderRunnable3 = new SenderRunnable(400, 599);
            Thread thread3 = new Thread(senderRunnable3);
            thread3.start();

            SenderRunnable senderRunnable4 = new SenderRunnable(600, 799);
            Thread thread4 = new Thread(senderRunnable4);
            thread4.start();

            SenderRunnable senderRunnable5 = new SenderRunnable(800, 999);
            Thread thread5 = new Thread(senderRunnable5);
            thread5.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

            System.out.println("All threads have done");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
