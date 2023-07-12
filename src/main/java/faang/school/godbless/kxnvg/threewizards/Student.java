package faang.school.godbless.kxnvg.threewizards;

import lombok.Getter;

@Getter
public class Student {

    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        points = 0;
    }

    public void takeReward(int reward) {
        points += reward;
    }
}
