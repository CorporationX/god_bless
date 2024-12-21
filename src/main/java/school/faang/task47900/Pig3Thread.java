package school.faang.task47900;


public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super(" Naf - naf ", " bricks ");
    }

    public void run() {
        buildHouse(4000);
    }
}
