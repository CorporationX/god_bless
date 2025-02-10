package school.faang.task_57062;

import lombok.Data;

@Data
public class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}
