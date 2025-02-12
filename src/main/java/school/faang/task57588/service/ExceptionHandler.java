package school.faang.task57588.service;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}