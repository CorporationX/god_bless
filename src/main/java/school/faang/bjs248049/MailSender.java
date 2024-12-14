package school.faang.bjs248049;

public class MailSender {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Thread one = new Thread(new SenderRunnable(1, 200), "one");
        one.start();
        Thread two = new Thread(new SenderRunnable(201, 400), "two");
        two.start();
        Thread three = new Thread(new SenderRunnable(401, 600), "three");
        three.start();
        Thread four = new Thread(new SenderRunnable(601, 800), "four");
        four.start();
        Thread five = new Thread(new SenderRunnable(801, 1000), "five");
        five.start();
        try {
            one.join();
            two.join();
            three.join();
            four.join();
            five.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ": ended. Time elapsed: " + (end - start));
    }

}
