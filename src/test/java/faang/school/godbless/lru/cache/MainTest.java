package faang.school.godbless.lru.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

public class MainTest {

    @Test
    void testCache() throws InterruptedException {
        Data data1 = new Data(1, "data1");
        Main.add(data1);
        sleep(Duration.ofSeconds(1));

        Data data2 = new Data(2, "data2");
        Main.add(data2);
        sleep(Duration.ofSeconds(1));

        Data data3 = new Data(3, "data3");
        Main.add(data3);
        sleep(Duration.ofSeconds(1));

        Data data4 = new Data(4, "data4");
        Main.add(data4);

        Assertions.assertEquals(0, Main.idDataCache.size());

        LocalDateTime data1TimestampBeforeGet = data1.getTimestamp();
        Data extractedData1 = Main.get(1);
        Assertions.assertEquals(1, Main.idDataCache.size());
        Assertions.assertNotEquals(data1TimestampBeforeGet, extractedData1.getTimestamp());

        sleep(Duration.ofMillis(1000));

        Main.get(2);
        Main.get(3);

        Assertions.assertEquals(3, Main.idDataCache.size());

        Main.get(4);
        Assertions.assertEquals(3, Main.idDataCache.size());
        Assertions.assertFalse(Main.idDataCache.containsKey(1));

        Main.get(2);
        Main.get(1);
        Assertions.assertEquals(3, Main.idDataCache.size());
        Assertions.assertFalse(Main.idDataCache.containsKey(3));
    }
}
