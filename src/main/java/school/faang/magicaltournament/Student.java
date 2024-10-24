package school.faang.magicaltournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;


    public void addPoints(int points) {
         this.points += points;
    }

    public int getPoints() {
        return points;
    }
}
