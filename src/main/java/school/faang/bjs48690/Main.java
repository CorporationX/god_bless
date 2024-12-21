package school.faang.bjs48690;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread part = new Thread(new SenderRunnable(0, 199));
        part.start();
        Thread part1 = new Thread(new SenderRunnable(200, 399));
        part1.start();
        Thread part2 = new Thread(new SenderRunnable(400, 599));
        part2.start();
        Thread part3 = new Thread(new SenderRunnable(600, 799));
        part3.start();
        Thread part4 = new Thread(new SenderRunnable(800, 999));
        part4.start();

        part.join();
        part1.join();
        part2.join();
        part3.join();
        part4.join();

        System.out.println("Finished sending");
    }
}
