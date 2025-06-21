package school.faang.bjs2_81593;

public class Pig2Thread extends PigThread {
    private static int constructionTime = 3000;

    public Pig2Thread() {
        super("Нуф-Нуф", "палки");
    }

    @Override
    public void run() {
        buildHouse(constructionTime);
    }
}
