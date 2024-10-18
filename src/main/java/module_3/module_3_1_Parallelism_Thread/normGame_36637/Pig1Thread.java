package module_3.module_3_1_Parallelism_Thread.normGame_36637;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        buildHouse(1000);
    }
}
