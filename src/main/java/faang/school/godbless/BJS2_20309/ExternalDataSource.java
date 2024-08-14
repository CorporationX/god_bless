package faang.school.godbless.BJS2_20309;

import java.time.LocalDateTime;
import java.util.Random;

public class ExternalDataSource {

    Random random = new Random();

    public Data getData(int id) {
        System.out.println("Data requested from external DataSource");
        return new Data(id, "New Data from external DataSource received: " + random.nextInt(100), LocalDateTime.now());
    }
}
