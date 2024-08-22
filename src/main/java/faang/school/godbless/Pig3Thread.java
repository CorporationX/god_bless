package faang.school.godbless;

public class Pig3Thread extends PigThread {

    public Pig3Thread() {
        super("Нуф-Нуф", 2);
    }

    @Override
    public void run() {
        buildHouse("кирпичей");
    }
}
