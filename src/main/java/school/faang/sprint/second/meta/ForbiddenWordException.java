package school.faang.sprint.second.meta;

public class ForbiddenWordException extends RuntimeException {
    public ForbiddenWordException() {
        super("Ваше сообщение содержит запрещенные слова");
    }
}
