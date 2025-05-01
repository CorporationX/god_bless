package school.faang.bjs274891;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;
}
