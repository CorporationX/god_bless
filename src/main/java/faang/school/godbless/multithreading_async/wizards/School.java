package faang.school.godbless.multithreading_async.wizards;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
public class School {
    private String name;
    private List<Student> team;

    public School(String name) {
        this.name = name;
        team = new ArrayList<>();
    }

    public int getTotalPoints(){
        return team.stream()
                .map(student -> student.getPoints())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void addStudent(Student student){
        team.add(student);
    }
}
