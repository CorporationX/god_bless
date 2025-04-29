package async.future;

import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        MasterCardService master = new MasterCardService(Executors.newFixedThreadPool(POOL_SIZE));
        master.doAll();
    }
}
