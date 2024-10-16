package normGame_36637;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        buildHouse(5000);
    }
}
