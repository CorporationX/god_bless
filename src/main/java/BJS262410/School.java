package BJS262410;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Data
public class School {
    private String name;
    private List<Student> team;
    private Integer teamPoints;

    public School(List<Student> team, String name) {
        this.team = team;
        this.name = name;
    }

    public Integer getTotalPoints() {
        if (name != null && !team.isEmpty()) {
            setTeamPoints(team.stream().mapToInt(Student::getPoints).sum());
        }
        return teamPoints;
    }
}
