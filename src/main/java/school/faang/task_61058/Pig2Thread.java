package school.faang.task_61058;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nuf-Nuf", Material.STICKS);
    }

    @Override
    public void run() {
        buildHouse(3000);
    }
}
