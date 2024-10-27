package school.faang.Sprints.Multithreading_Async.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public int getTotalPoints() {
       return studentList.stream()
               .mapToInt(Student::getPoints)
               .sum();
    }
}
