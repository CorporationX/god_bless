package bjs262388;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints(List<Student> team) {
        if (Objects.isNull(team) || team.isEmpty()) {
            log.error("Team could not be null or empty",
                    new TournamentException("IllegalArgumentException"));
        }
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
