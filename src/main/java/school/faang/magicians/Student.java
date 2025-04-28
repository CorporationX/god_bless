package school.faang.magicians;

import lombok.Data;

@Data
public class Student {
    private final String name;
    private int studyYear;
    private int points;

    public Student(String name, int studyYear, int points) {
        this.name = name;
        this.studyYear = studyYear;
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
