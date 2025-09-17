package school.faang.bjs2_91285;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Naf-Naf", "bricks");
    }

    @Override
    public void run() {
        buildHouses(30000);
    }
}
