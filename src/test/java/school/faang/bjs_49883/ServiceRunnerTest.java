package school.faang.bjs_49883;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceRunnerTest {

    @Test
    void runService() {
        ServiceRunner serviceRunner = new ServiceRunner();
        Assertions.assertEquals(0, serviceRunner.getResultPayment());
        Assertions.assertEquals(0, serviceRunner.getResultAnalytics());
        serviceRunner.runService();
        Assertions.assertEquals(10000, serviceRunner.getResultPayment());
        Assertions.assertEquals(1000, serviceRunner.getResultAnalytics());
    }
}