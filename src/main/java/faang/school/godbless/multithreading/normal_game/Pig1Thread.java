package faang.school.godbless.multithreading.normal_game;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        super.done();
    }
}
