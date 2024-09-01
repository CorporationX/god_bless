package faang.school.godbless.tournament;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public void task(Student student) {
        Random random = new Random();
        if (random.nextBoolean()) {
            student.setPoints(student.getPoints() + reward);
            System.out.println("Student completed this task!");
        }
    }
}
