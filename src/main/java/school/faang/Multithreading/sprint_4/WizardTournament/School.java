package school.faang.Multithreading.sprint_4.WizardTournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class School {
    @Getter
    private final String name;
    private final List<Student> students;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }



    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student student : students) {
            totalPoints += student.getPoints();
        }
        return totalPoints;
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

}
