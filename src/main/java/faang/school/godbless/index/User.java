package faang.school.godbless.index;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
