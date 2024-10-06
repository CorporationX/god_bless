package school.faang.HashMaps.countingAbsenteeism;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String name;
    private String faculty;
    private int year;
}
