package faang.school.godbless.multithreading.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class Food {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
