package school.faang.bjs251129;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class School {

    private final String school;
    private final List<Student> team;

    public School(String school, List<Student> teams) {
        if (school == null || school.isEmpty()) {
            log.error("School name is null or empty");
            throw new IllegalArgumentException("School name cannot be null or empty");
        }
        if (teams == null || teams.isEmpty()) {
            log.error("Team list is null or empty");
            throw new IllegalArgumentException("Team list cannot be null or empty");
        }
        this.school = school;
        this.team = teams;
    }

    public int getTotalPoint() {
        int totalPoints = getTeam().stream()
                .mapToInt(Student::getPoints).sum();
        log.info("{} Total points calculated: {} ", school, totalPoints);
        return totalPoints;
    }
}

