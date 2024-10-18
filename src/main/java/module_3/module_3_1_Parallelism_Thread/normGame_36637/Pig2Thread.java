package module_3.module_3_1_Parallelism_Thread.normGame_36637;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        buildHouse(3000);
    }
}
