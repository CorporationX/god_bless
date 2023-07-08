package faang.school.godbless.sprint4_multithreading.normal_game;

public class Pig3Thread extends PigThread{
    public Pig3Thread(String pigName, int material) {
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
