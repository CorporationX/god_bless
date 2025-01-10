package school.faang.sprint4.bjs_50802;

import java.util.List;

public record School(String name, List<Student> team) {

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void updatePoints(int reward) {
        for (Student student : team) {
            student.setPoints(reward);
        }
    }
}
