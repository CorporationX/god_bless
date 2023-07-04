package faang.school.godbless.wizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> studentList;

    public int getTotalPoints(){
        return studentList.stream().mapToInt(Student::getPoints).sum();
    }
}
