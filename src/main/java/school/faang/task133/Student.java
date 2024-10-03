package school.faang.task133;

import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    @Getter
    private String faculty;
    @Getter
    private int year;
}
