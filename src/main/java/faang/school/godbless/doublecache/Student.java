package faang.school.godbless.doublecache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Student {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name + " (id: " + id + ")";
    }
}
