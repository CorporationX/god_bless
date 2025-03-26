package school.faang.double_cache_cache.BJS2_56997;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Subject(String name) {
    private static final Logger LOGGER = LoggerFactory.getLogger(Subject.class);

    public Subject(@NonNull String name) {
        if (name.isBlank()) {
            LOGGER.error("Name cannot be blank");
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }
}
