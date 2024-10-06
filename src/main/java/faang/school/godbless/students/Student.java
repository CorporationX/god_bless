package faang.school.godbless.students;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {
    @NonNull
    private String name;
    @NonNull
    private String faculty;
    @NonNull
    private Integer year;
}
