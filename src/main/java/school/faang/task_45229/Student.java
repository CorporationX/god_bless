package school.faang.task_45229;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Student {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final String name;

    public Student(String name) {
        this.id = idCounter.getAndIncrement();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
}
