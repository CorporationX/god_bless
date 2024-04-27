package faang.school.godbless.wizard_tournament;


import lombok.Getter;

@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
