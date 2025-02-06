package school.faang.doublecache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Student {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
