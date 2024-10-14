package school.faang.bjs2_32525.model;

import lombok.Data;


@Data
public class Student {
    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
        this.id = IdSequence.incrementIdCountStudent();
    }
}
