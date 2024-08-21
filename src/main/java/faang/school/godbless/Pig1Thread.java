package faang.school.godbless;

public class Pig1Thread extends PigThread{

    public Pig1Thread() {
        super("Nuf-Nuf", "straw");
    }


    @Override
    public void run() {
        buildHouse(3000);
    }
}
