package school.faang.threemagicians;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer year;
    private Integer points;
}
