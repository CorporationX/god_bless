package school.faangSprint3.t17;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Нуф-Нуф", "палки");
    }

    @Override
    public void run() {
        buildHouse(3000);
    }
}