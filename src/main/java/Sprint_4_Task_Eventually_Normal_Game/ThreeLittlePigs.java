package Sprint_4_Task_Eventually_Normal_Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class ThreeLittlePigs {

    public static void main(String[] args) {

    PigNifNif1Thread nifNif = new PigNifNif1Thread();

    PigNufNuf2Thread nufNuf = new PigNufNuf2Thread();
    PigNafNaf3Thread nafNaf = new PigNafNaf3Thread();

    nifNif.start();
    nufNuf.start();
    nafNaf.start();

}

}
