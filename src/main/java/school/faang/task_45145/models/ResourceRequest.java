package school.faang.task_45145.models;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class ResourceRequest {
    public static final int MIN_LOAD = 1;
    public static final String ERROR_LOAD = "Load must be greater than or equal to 1";

    private final double load;

    public ResourceRequest(double load) {
        if (load < MIN_LOAD) {
            log.error(ERROR_LOAD);
            throw new IllegalArgumentException(ERROR_LOAD);
        }

        this.load = load;

        log.info("ResourceRequest created with load: {}", load);
    }
}
