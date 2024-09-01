package faang.school.multithreadingparallelismthread.thetriwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private final String name;
    @Setter
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints).sum();

    }
}
