package normGame_36637;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        buildHouse(1000);
    }
}
