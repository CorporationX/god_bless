package school.faang.sprint4.task51100.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class School {

    @Getter
    private final String name;
    private final List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public List<Student> getTeam() {
        return new ArrayList<>(students);
    }


}
