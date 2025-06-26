package school.faang.module4.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public void receivePoints(int points) {
        if (team.isEmpty()) {
            System.out.println("team is empty");
            return;
        }
        int partOfPoints = points / team.size();
        synchronized (team) {
            team.stream()
                    .forEach(student -> {
                        student.setPoints(student.getPoints() + partOfPoints);
                    });
            if (points - partOfPoints * team.size() > 0) {
                var student = team.get(0);
                student.setPoints(student.getPoints() + (points - partOfPoints * team.size()));
            }
        }
    }

    public int getTotalPoints() {
        return team.stream()
                .reduce(0, (points, student) -> points + student.getPoints(),
                        (points, studentPoints) -> points + studentPoints);
    }
}
