package school.faang.bjs2_91285;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nyf-Nyf", "branches");
    }

    @Override
    public void run() {
        buildHouses(15000);
    }
}
