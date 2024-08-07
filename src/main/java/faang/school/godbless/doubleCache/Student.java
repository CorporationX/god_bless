package faang.school.godbless.doubleCache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name.toUpperCase() + " (id: " + id + ")";
    }
}
