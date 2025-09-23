package school.faang.user_activity_analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Проект: god_bless
 * Класс UserAction
 * Автор: Vital
 * Дата: 22.09.2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
