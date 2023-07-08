package triwizard_tournament;

public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int points, int year) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
