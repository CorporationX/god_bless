package school.faang.async;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MasterCardService().doAll();
    }
}
