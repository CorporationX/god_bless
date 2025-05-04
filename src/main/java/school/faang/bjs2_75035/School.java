package school.faang.bjs2_75035;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().reduce(0, (sum, b) -> sum + b.getPoints(), Integer::sum);
    }
}
