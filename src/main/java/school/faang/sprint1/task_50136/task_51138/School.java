package school.faang.sprint1.task_50136.task_51138;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private final String name;
    private final List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
