package school.faang.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public void executeTask(School school) {
        try {
            log.info("Task " + name + " started school " + school.getName());
            Thread.sleep(difficulty * 1000L);
            for (Student student : school.getTeam()) {
                student.addPoints(this.getReward());
            }
            log.info("Task " + name + " completed by school " + school.getName() + ". Students gained " + reward + " points each.");
        } catch (InterruptedException e) {
            log.error("Thread had been interrupted during task " + name + "for school " + school.getName(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task execution was interrupted", e);
        }
    }
}
