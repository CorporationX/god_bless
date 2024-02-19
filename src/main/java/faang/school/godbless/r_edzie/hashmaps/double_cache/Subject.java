package faang.school.godbless.r_edzie.hashmaps.double_cache;

import lombok.Data;

@Data
public class Subject {
    private int id;
    private String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
