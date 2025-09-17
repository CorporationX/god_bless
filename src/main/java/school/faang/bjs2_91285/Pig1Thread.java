package school.faang.bjs2_91285;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Nif-Nif", "straw");
    }

    @Override
    public void run() {
        buildHouses(10000);
    }
}
