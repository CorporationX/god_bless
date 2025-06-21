package school.faang.bjs2_81593;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        buildHouse(2000);
    }
}
