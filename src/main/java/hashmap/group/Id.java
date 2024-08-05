package hashmap.group;

import lombok.Data;
import lombok.NonNull;

@Data
public class Id {
    @NonNull
    private final String faculty;
    private final int year;
}
