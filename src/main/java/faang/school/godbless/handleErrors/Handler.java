package faang.school.godbless.handleErrors;

public interface Handler<T> {
    T exception(Exception handler);
}
