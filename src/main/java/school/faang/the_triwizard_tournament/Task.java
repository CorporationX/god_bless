package school.faang.the_triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Проект: god_bless
 * Класс Task
 * Автор: Vital
 */

@Data
@AllArgsConstructor
public class Task {
    @NonNull
    private String name;
    private int difficulty;
    private int reward;
}