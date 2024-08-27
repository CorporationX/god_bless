package faang.school.godbless.fourthsprint.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class Pair<T, U> {
    private final T first;
    private final U second;

    @Override
    public String toString() {
        return "Pair of: " + first + ", " + second;
    }
}
