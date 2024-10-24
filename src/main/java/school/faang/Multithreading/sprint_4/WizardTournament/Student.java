package school.faang.Multithreading.sprint_4.WizardTournament;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int points){
        this.points = points;
    }
}
