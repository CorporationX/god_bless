package work.at.microsoft;

public class MailSender {
    public static void main(String[] args) {
        final Thread threadOne = new Thread(new SenderRunnable(0, 200));
        final Thread threadTwo = new Thread(new SenderRunnable(2001, 400));
        final Thread threadThree = new Thread(new SenderRunnable(401, 600));
        final Thread threadFour = new Thread(new SenderRunnable(601, 800));
        final Thread threadFive = new Thread(new SenderRunnable(801, 1000));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadFive.start();

        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
            threadFive.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
