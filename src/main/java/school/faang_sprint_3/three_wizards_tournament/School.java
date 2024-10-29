package school.faang_sprint_3.three_wizards_tournament;

import java.util.List;

public record School(String name, List<Student> students) {

    public int getTotalPoints() {
        return students.stream().mapToInt(Student::getPoints).sum();
    }
}
