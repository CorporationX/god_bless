package school.faang.turnir;

import java.util.List;

public record School(String name,
                     List<Student> team) {


    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void updateStudentsScores(int score) {
        team.forEach(student -> student.updatePoints(score));
    }
}
