package school.faang.doublecash;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Subject {
    private int id;
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}
