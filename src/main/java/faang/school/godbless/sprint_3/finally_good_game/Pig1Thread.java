package faang.school.godbless.sprint_3.finally_good_game;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println("House built of straw.");
    }
}
