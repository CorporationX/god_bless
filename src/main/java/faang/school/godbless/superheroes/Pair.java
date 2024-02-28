package faang.school.godbless.superheroes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Pair <T, U> {

    private T first;
    private U second;
}
