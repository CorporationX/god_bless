package faang.school.godbless.DoubleCache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
public class Student {
    private int id;
    @EqualsAndHashCode.Exclude
    private String name;
}
