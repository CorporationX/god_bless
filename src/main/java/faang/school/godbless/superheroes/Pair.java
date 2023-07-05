package faang.school.godbless.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<T, T1> {
    private T superhero1;
    private T1 superhero2;
}
