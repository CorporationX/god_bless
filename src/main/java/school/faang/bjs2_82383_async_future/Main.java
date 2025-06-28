package school.faang.bjs2_82383_async_future;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MasterCardService mcService = new MasterCardService(Executors.newCachedThreadPool());
        mcService.executePaymentAndAnalyticsAsync();
    }
}
