package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return 0;
    }
}
