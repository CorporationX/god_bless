package school.faang.BJS2_92822;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Slf4j
@AllArgsConstructor
@Getter
@ToString
public class School {
    private final String name;
    private final List<Student> team;
    private final ExecutorService executor;

    public synchronized void getTotalPoints() {
        int sumPoints = team.stream()
                .mapToInt(student -> student.getPoints())
                .sum();
        log.info("Команда {} набрала всего очков {}", team, sumPoints);
    }
}
