package school.faang.bks2_82429;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService(Executors.newFixedThreadPool(3));
        masterCardService.doAll();
    }
}
