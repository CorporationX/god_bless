package faang.school.godbless;

public class Pig2Thread extends PigThread {

    public Pig2Thread() {
        super("Naf-Naf", "bricks");
    }


    @Override
    public void run() {
        buildHouse(2000);
    }
}
