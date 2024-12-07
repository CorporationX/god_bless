package school.faang.task_45229;

import lombok.Data;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Subject {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final String name;

    public Subject(String name) {
        this.id = idCounter.getAndIncrement();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    //Сделал сравнение предметов только по имени чтобы не плодить одинаковые предметы с разными id
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
