package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return 0;
    }
}
