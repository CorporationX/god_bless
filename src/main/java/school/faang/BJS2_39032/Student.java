package school.faang.BJS2_39032;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoits(int newPoints){
        this.points += newPoints;
    }
}
