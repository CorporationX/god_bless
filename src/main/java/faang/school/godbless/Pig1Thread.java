package faang.school.godbless;

public class Pig1Thread extends PigThread {

    public Pig1Thread() {
        super("Ниф-Ниф", 1);
    }

    @Override
    public void run() {
        buildHouse("соломы");
    }
}
