package school.faang.schitaem_proguly;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Student {
    private final String NAME;
    private final String FACULTY;
    private final int YEAR;
}