package faang.school.godbless;

public class Pig3Thread extends PigThread{

    public Pig3Thread() {
        super("Nif-Nif", "sticks");
    }

    @Override
    public void run() {
        buildHouse(1000);
    }
}
