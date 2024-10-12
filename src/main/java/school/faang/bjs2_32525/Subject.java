package school.faang.bjs2_32525;

import lombok.Data;

@Data
public class Subject {
    private static int idCount;

    private int id;
    private String name;

    public Subject(String name) {
        this.name = name;
        idCount++;
        id = idCount;
    }
}
