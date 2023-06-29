package faang.school.godbless.multithreading.normal_game;

public class Pig3Thread extends PigThread{
    public Pig3Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        super.done();
    }
}
