package module_3.module_3_1_Parallelism_Thread.normGame_36637;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        buildHouse(5000);
    }
}
