package faang.school.godbless.sprint_3.multithreading_future.tournament_of_three_wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        if (task.getDifficulty() == 0) {
            throw new IllegalArgumentException("Задание такого уровня сложности не поддерживается на турнире");
        }
        return CompletableFuture.supplyAsync(() -> {
            List<Student> students = school.getTeam();
            System.out.printf("Школа %s начинает выполнение задания %s%n", school.getName(), task.getName());
            for (Student student : students) {
                int random = ThreadLocalRandom.current().nextInt(task.getDifficulty());
                if (random > 0) {
                    System.out.printf("%s из школы %s не смог пройти испытание и не получает %d очков%n", student.getName(), school.getName(), task.getReward());
                    continue;
                }
                System.out.printf("Студент: %s из школы %s смог выполнить задание и получает награду в виде %d очков%n", student.getName(), school.getName(), task.getReward());
                student.setPoints(student.getPoints() + task.getReward());
            }
            return school;
        });
    }
}