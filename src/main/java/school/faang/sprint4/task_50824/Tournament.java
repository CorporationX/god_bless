package school.faang.sprint4.task_50824;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getExecutionTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            assignRewardToRandomStudent(school, task);
            log.info("{} by {} was completed", task.getName(), school.getName());
            return school;
        });
    }

    private void assignRewardToRandomStudent(School school, Task task) {
        List<Student> students = school.getStudents();
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No students available to assign rewards");
        }

        Random random = new Random();
        int reward = task.getReward();
        Student selectedStudent = students.get(random.nextInt(students.size()));
        selectedStudent.getPoints().addAndGet(reward);
    }

    public School calculateWinner(List<School> schools) {
        schools.forEach(System.out::println);
        return schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElseThrow(() -> new IllegalArgumentException("There is no winner for this tournament"));
    }
}
