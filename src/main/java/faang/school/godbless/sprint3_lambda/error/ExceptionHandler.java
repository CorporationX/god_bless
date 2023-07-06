package faang.school.godbless.sprint3_lambda.error;

@FunctionalInterface
//объявление интерфейса ExceptionHandler, который принимает тип T в качестве параметра:
public interface ExceptionHandler<T> {
    // Этот интерфейс определяет метод handle,который принимает исключение Exception и возвращает значение типа T:
    T handle(Exception e);
}
