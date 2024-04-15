package faang.school.godbless.outlook;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        Thread thread_1 = new Thread(new SenderRunnable(1,200));
        Thread thread_2 = new Thread(new SenderRunnable(201,400));
        Thread thread_3 = new Thread(new SenderRunnable(401, 600));
        Thread thread_4 = new Thread(new SenderRunnable(601, 800));
        Thread thread_5 = new Thread(new SenderRunnable(801, 1000));

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_5.start();

        thread_1.join();
        thread_2.join();
        thread_3.join();
        thread_4.join();
        thread_5.join();

        System.out.println("All email sends");
    }
}
