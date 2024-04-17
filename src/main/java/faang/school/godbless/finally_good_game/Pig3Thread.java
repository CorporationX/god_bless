package faang.school.godbless.finally_good_game;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println("House built of bricks.");
    }
}
