package faang.BJS2_74958;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> students;

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
