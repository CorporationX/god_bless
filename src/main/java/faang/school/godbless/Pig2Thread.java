package faang.school.godbless;

public class Pig2Thread extends PigThread {

    public Pig2Thread() {
        super("Нуф-Нуф", 2);
    }

    @Override
    public void run() {
        buildHouse("палок");
    }
}
