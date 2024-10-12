package school.faang.bjs2_32525;

import lombok.Data;


@Data
public class Student {
    private static int idCount;

    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
        idCount++;
        this.id = idCount;
    }
}
