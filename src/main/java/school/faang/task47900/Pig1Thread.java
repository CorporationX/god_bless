package school.faang.task47900;


public class Pig1Thread extends PigThread {

    public Pig1Thread() {
        super("Nif - nif ", " straw ");
    }

    @Override
    public void run() {
        buildHouse(3000);
    }
}
