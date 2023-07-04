package faang.school.godbless.Sprint4.TriwizardTournament;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Student {
    private String name;
    private int year;
    private int magicLvl;
    private int points = 0;
    private boolean isDoing = false;

    public Student(String name, int year, int magicLvl) {
        this.name = name;
        this.year = year;
        this.magicLvl = magicLvl;
    }

    public void updatePoints(int skillsLvl) {
        this.points += skillsLvl;
    }

    // не уверен что это лучшее решение, но оно работает и работает без ошибок)))
    // пробовал сделать с синхранизацией по студенту, тогда студенты из одной школы,
    // работали не корректно
    public void studentDoing(Task task) {
        while (isDoing) {
            try {
                int time = magicLvl >= task.getDifficulty() ? 0 : task.getDifficulty();
                Thread.sleep(500 + time * 1000);
                updatePoints(task.getReward());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(name + " has " + points + " points");
            studentDoing(task);
        }
    }
}
