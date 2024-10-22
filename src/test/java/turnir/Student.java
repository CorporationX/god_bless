package turnir;

public class Student {
    private String name;
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

    public int updatePoints(int points) {
        if (this.year == 1) {
            this.points = this.points + points + 1;
        } else if (this.year == 2) {
            this.points = this.points + points + 2;
        } else if (this.year == 3) {
            this.points = this.points + points + 3;
        } else {
            this.points = this.points + points + 5;
        }
        return this.getPoints();
    }
}
