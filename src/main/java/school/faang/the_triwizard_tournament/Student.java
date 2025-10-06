package school.faang.the_triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Проект: god_bless
 * Класс Student
 * Автор: Vital
 */

@Data
@AllArgsConstructor
public class Student {
    @NonNull
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}