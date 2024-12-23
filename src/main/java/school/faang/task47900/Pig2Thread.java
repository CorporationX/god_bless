package school.faang.task47900;


public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nuf - nuf ", " sticks ");
    }

    @Override
    public void run() {
        buildHouse(2000);
    }
}
