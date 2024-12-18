package school.faang.task_45390;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subject {
    private static int idCounter = 1;

    @EqualsAndHashCode.Include
    private final int id;
    @Getter
    private final String name;

    public Subject(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.id = idCounter++;
        this.name = name;
        log.info("Subject {} created", name);
    }

    @Override
    public String toString() {
        return name;
    }
}