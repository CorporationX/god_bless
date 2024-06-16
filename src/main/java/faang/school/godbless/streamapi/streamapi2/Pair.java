package faang.school.godbless.streamapi.streamapi2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pair<T> {
    private T firstInt;
    private T secondInt;
}
