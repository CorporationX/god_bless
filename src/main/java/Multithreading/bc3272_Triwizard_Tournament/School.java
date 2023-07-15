package Multithreading.bc3272_Triwizard_Tournament;

import lombok.Data;

@Data
public class School {
    private String name;
    private int year;
    private int points;

    public School(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public int getTotalPoints() {

        return getPoints();
    }
}
