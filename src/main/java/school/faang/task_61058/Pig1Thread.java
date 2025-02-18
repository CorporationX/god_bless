package school.faang.task_61058;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Nif-Nif", Material.STRAW);
    }

    @Override
    public void run() {
        buildHouse(2000);
    }
}
