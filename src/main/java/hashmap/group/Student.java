package hashmap.group;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {
    @NonNull
    private final String name;
    @NonNull
    private final String faculty;
    private final int year;
}
