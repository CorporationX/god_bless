package faang.school.godbless.triWizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int points;
    private School school;
}
