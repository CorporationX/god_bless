package faang.school.godbless.sprint4_multithreading.normal_game;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName, int material) {
        super(pigName, material);
    }

    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
