package faang.school.godbless.asyncAndFuture.triwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
public class School {
    @Getter
    private String name;
    private List<Student> team;

    public synchronized int getTotalPoints() {
        return team.stream()
                .map((Student::getPoints))
                .reduce(Integer::sum).orElse(0);
    }

    public List<Student> getTeam() {
        return new ArrayList<>(team);
    }
}
