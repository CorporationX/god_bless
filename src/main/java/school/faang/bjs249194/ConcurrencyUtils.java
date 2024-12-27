package school.faang.bjs249194;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class ConcurrencyUtils {
    public void tryWait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            log.error("Error while waiting = {}", e.getMessage());
        }
    }
}
