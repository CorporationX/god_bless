package school.faang.tournament_wizzards;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public record School(String name, List<Student> team) {

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
