package school.faang.threelittlepigs;

public class Pig3Thread extends PigThread{
    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }


    @Override
    public void run() {
        buildHouse(5000);
    }
}
