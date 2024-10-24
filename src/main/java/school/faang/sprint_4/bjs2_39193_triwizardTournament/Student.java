package school.faang.sprint_4.bjs2_39193_triwizardTournament;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int year;
    private final int mastery;
    private int points;

    public Student (String name, int year, int mastery) {
        this.name = name;
        this.year = year;
        this.mastery = mastery;
        points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
