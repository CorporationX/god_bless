package faang.school.godbless.BJS2_714;

import lombok.Data;

@Data
public class Subject {
    private static int count;
    private int id;
    private String name;

    public Subject(String name) {
        this.id = ++count;
        this.name = name;
    }
}