package school.faang.asyncandfuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MasterCardService mcs = new MasterCardService();
        mcs.doAll();
    }
}
