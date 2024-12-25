package school.faang.task_50763;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class School {
    private final String name;
    private final Map<String, Student> team;

    public School(String name) {
        this.name = name;
        this.team = new ConcurrentHashMap<>();
    }

    public void addStudent(Student student) {
        team.put(student.getName(), student);
    }

    public void addReward(Task task) {
        team.values().forEach(student -> student.addPoints(task.getReward()));
    }

    public int getTotalPoints() {
        return team.values().stream()
                .mapToInt(student -> student.getPoints().get())
                .sum();
    }
}