package school.faang.count.skipping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Course {
    private final String faculty;
    private final int year;
}
