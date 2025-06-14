package school.faang.bjs2_79679;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Student {
    String name;

    @Override
    public String toString() {
        return name;
    }
}
