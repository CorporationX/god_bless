package school.faang.sprint.second.meta;

public class EmptyMessageException extends RuntimeException {
    public EmptyMessageException() {
        super("Нельзя передавать пустое сообщение");
    }
}
