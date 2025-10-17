package school.faang.the_triwizard_tournament;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * Проект: god_bless
 * Класс School
 * Автор: Vital
 */

@Data
public class School {
    @NonNull
    private String name;
    @NonNull
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}