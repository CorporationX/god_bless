package school.faang.cache;

import lombok.Data;

@Data
public class Subject {
    private final String name;

    public Subject(String name) {
        this.name = name;
    }
}
