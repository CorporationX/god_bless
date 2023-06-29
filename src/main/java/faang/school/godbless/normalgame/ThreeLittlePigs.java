public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Thread Pig1 = new Thread(new Pig1Thread());
        Thread Pig2 = new Thread(new Pig2Thread());
        Thread Pig3 = new Thread(new Pig3Thread());

        Pig1.start();
        Pig2.start();
        Pig3.start();

        Pig1.join();
        Pig2.join();
        Pig3.join();

        System.out.println("Игра окончена");
    }
}
