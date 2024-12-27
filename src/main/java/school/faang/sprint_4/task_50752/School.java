package school.faang.sprint_4.task_50752;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@ToString
public class School {
    private static final Random RANDOM = new Random();

    @NonNull
    private final String name;
    @NonNull
    private final List<Student> team;

    public synchronized int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public synchronized void addStudent(Student student) {
        team.add(student);
    }

    public synchronized void removeStudent(Student student) {
        team.remove(student);
    }

    public synchronized List<Student> getTeam() {
        return List.copyOf(team);
    }

    public synchronized void completeTask(Task task) {
        Student student = team.get(RANDOM.nextInt(team.size() - 1));
        student.addPoints(task.reward());
    }
}
