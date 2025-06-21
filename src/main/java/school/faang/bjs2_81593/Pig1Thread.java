package school.faang.bjs2_81593;

public class Pig1Thread extends PigThread {
    private static int constructionTime = 2000;

    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        buildHouse(constructionTime);
    }
}
