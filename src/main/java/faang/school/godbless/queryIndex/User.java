package faang.school.godbless.queryIndex;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
