package school.faang.bjs2_92858;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int studyYear;
    private final int maxYear = 5;
    private int points = 0;

    public Student(String name, int studyYear) {
        this.name = DataValidator.requireNotBlank(name);
        this.studyYear = DataValidator.requirePositiveAndRange(studyYear, maxYear);
    }

    public void addPoints(int points) {
        this.points += points;
    }
}