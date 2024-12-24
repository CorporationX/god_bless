package school.faang.sprint_4.task_50773;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tournament {
    public School startTask(School school, Task task) {
        log.info("{} start task {}", school.getName(), task.getName());
        try {
            Thread.sleep(1000L * task.getDifficult());
        } catch (InterruptedException e) {
            log.error("The task thread is going to be stopped", e);
        }
        log.info("{} end task {}", school.getName(), task.getName());
        school.getTeam().forEach(student -> student.addPoints(task.getReward()));
        return school;
    }
}
