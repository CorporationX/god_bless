package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Проект: god_bless
 * Класс Notification
 * Автор: Vital
 * Дата: 17.09.2025
 */

@AllArgsConstructor
@Getter
@Setter
public class Notification {
    NotificationType type;
    String message;
}
