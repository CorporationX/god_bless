package faang.school.godbless.BJS2_24400;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
