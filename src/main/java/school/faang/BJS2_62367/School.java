package school.faang.BJS2_62367;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> team;
    private final Object lock = new Object();

    public void updatePoints(int reward) {
        synchronized (lock) {
            team.forEach(student -> student.addPoints(reward));
        }
    }

    public int getTotalPoints() {
        synchronized (lock) {
            return team.stream().mapToInt(Student::getPoints).sum();
        }
    }
}


