package faang.school.godbless.sprint4.base;


public class App {
    public static void main(String[] args) throws Exception {
        MilitaryBase base = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();

        Thread thread = new Thread(base);
        Thread thread2 = new Thread(base2);

        thread.start();
        thread2.start();

        base.sendMessage(base2, "Hello from base1");
        Thread.sleep(1000);

        base.stop();
        base2.stop();

        thread.join();
        thread2.join();
    }
}
