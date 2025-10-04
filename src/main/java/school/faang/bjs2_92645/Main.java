package school.faang.bjs2_92645;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
