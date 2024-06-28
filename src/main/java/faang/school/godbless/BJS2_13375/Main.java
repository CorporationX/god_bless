package faang.school.godbless.BJS2_13375;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        try {
            masterCardService.doAll();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
