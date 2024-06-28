package faang.school.godbless.domain.task_tournament;

import java.util.List;

public record School(String name, List<Student> team) {

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student student : team) {
            totalPoints += student.points();
        }
        return totalPoints;
    }
}
