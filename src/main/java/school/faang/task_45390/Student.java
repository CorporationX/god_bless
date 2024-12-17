package school.faang.task_45390;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    private static int idCounter = 1;

    @EqualsAndHashCode.Include
    private final int id;
    @Getter
    private final String name;

    public Student(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.id = idCounter++;
        this.name = name;
        logger.info("Student {} created", name);
    }

    @Override
    public String toString() {
        return name;
    }
}