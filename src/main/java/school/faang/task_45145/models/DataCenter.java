package school.faang.task_45145.models;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Getter
@ToString
public class DataCenter {
    public static final String ERROR_NAME = "Name cannot be null or blank";

    private final String name;
    private final Set<Server> servers = new HashSet<>();

    public DataCenter(String name) {
        if (name == null || name.isBlank()) {
            log.error(ERROR_NAME);
            throw new IllegalArgumentException(ERROR_NAME);
        }

        this.name = name;

        log.info("Data Center '{}' has been successfully created", name);
    }
}
