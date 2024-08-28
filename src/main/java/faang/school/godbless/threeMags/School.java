package faang.school.godbless.threeMags;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }

    public void addPoints(int points) {
        for (Student student : team) {
            student.setPoints(student.getPoints() + points);
        }
    }

    public School submitTask(Task task) {
        System.out.println(name + " начинает задание " + task.getName());

        try {
            Thread.sleep(1000L * task.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " закончили задание " + task.getName());

        addPoints(task.getReward());

        return this;
    }
}
