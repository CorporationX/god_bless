package school.faang.countabsences;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private Integer year;
}
