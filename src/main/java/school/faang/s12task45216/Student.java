package school.faang.s12task45216;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private final int id;
    private final String name;
}
