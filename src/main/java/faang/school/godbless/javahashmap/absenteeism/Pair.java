package faang.school.godbless.javahashmap.absenteeism;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Pair<T, U> {
    public final T first;
    public final U second;
}
