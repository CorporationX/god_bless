package school.faang.wow.exception;

import school.faang.wow.domain.Quest;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
public class QuestExecutionException extends RuntimeException {
    public QuestExecutionException(Quest quest, Throwable cause) {
        super("Ошибка выполнения квеста %s".formatted(quest.name()), cause);
    }
}
