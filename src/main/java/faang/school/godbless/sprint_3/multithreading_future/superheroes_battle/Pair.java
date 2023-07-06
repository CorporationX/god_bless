package faang.school.godbless.sprint_3.multithreading_future.superheroes_battle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<T, U> {
    private T first;
    private U second;
}