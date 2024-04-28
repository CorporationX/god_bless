package faang.school.godbless.module.fourth.async.wizards;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();
    
    public School(String name) {
        this.name = name;
    }
    
    public void addStudent(Student student) {
        team.add(student);
    }
    
    public int getTotalPoints() {
        return team.stream().mapToInt(student -> student.getPoints()).sum();
    }
}
