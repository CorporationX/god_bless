package school.faang.wizards.exception;

import school.faang.wizards.domain.Task;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
public class TaskExecutionException extends RuntimeException {
    public TaskExecutionException(Task task, Throwable cause) {
        super("Ошибка выполнения задачи %s".formatted(task.name()), cause);
    }
}
