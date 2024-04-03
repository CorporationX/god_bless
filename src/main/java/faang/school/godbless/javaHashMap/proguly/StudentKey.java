package faang.school.godbless.javaHashMap.proguly;

import lombok.Data;
import lombok.NonNull;

@Data
public class StudentKey {
    @NonNull
    private String faculty;
    @NonNull
    private int year;
}
