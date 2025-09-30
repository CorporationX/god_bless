package school.faang.future_completable_future.bjs2_2906;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static school.utils.Utils.pickRandom;

@AllArgsConstructor
public class School {
    @Getter
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints).sum();
    }

    public Student getStudentForAward() {
        return pickRandom(team);
    }
}