package school.faang.bjs2_32525.model;

import lombok.Data;

@Data
public class Subject {
    private int id;
    private String name;

    public Subject(String name) {
        this.name = name;
        id = IdSequence.incrementIdCountSubject();
    }
}
