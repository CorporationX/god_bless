package school.faang.triwizard_tornament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public static CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("команда из школы {} начала задание {}", school.name(), task.name());

            for (Student student : school.team()) {
                log.info("студент {} начал проходить испытание {}", student.getName(), task.name());
                try {
                    Thread.sleep(task.difficulty() * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Error!!!!!!!!!!!!!!!!!! ALARM!!!!!!!!!!!");
                }

                if (Math.random() < 0.5) {
                    log.info("Студент {} справился с испытанием {}", student.getName(), task.name());
                    student.addPoints(task.reward());
                } else {
                    log.info("Студент {} не справился с испытанием {}", student.getName(), task.name());
                }
            }

            log.info("команда из школы {} закончила проходить задание {}", school.name(), task.name());

            return school;
        });
    }
}
