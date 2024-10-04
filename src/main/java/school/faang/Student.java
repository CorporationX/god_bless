package school.faang;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {

    private final int id;
    private final String name;
}
