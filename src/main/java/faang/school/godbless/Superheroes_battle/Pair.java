package faang.school.godbless.Superheroes_battle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<T, T1> {
    private T first;
    private T1 second;
}
// пришлось делать свой, т.к импортируемый не позволял получить доступ к элементам пары