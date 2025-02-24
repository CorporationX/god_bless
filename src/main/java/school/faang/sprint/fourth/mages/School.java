package school.faang.sprint.fourth.mages;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class School {
    @NonNull
    private String name;
    @NonNull
    private List<Student> team;

    public School(@NonNull String name, @NonNull List<Student> team) {
        validateData(name, team);
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    private void validateData(@NonNull String name, @NonNull List<Student> team) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (team.isEmpty()) {
            throw new IllegalArgumentException("Team cannot be blank");
        }
    }
}
