package faang.school.godbless.magicians;

public class Student {
    private final String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void changePoints(int p) {
        points += p;
    }
}
