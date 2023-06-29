package faang.school.godbless.multithreading.normal_game;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        super.done();
    }
}
