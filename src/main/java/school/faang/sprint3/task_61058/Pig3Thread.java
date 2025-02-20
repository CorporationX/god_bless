package school.faang.sprint3.task_61058;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Naf-Naf", Material.BRICKS);
    }

    @Override
    public void run() {
        buildHouse(4000);
    }
}
