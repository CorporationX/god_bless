package sprint_4.sprint_4_1_async_future.tournamentTriwizard_39044;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private final List<Student> students = new ArrayList<>();

    public long getTotalPoints(){
        return students.stream()
                .mapToLong(Student::getPoints)
                .sum();
    }

}