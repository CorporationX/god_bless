package faang.school.godbless.Task_18;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new SenderRunnable(0, 200));
        threadOne.start();
        Thread threadTwo = new Thread(new SenderRunnable(200, 400));
        threadTwo.start();
        Thread threadThree = new Thread(new SenderRunnable(400, 600));
        threadThree.start();
        Thread threadFour = new Thread(new SenderRunnable(600, 800));
        threadFour.start();
        Thread threadFive = new Thread(new SenderRunnable(800, 1000));
        threadFive.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();
        threadFive.join();
        System.out.println("All of letters are send");

    }
}
