package faang.school.godbless.tournament_of_three;

import java.util.List;

public record School(String name, List<Student> studentList) {
    public int getTotalPoints() {
        return studentList.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
