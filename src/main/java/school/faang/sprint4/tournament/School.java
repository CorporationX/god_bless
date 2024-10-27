package school.faang.sprint4.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();
}
