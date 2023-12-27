package faang.school.godbless.multi_paral.task7mice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Food {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
