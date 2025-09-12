package school.faang.BJS2_86023;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = true)
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    @Getter
    private final String name;
}
