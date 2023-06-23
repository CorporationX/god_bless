package sprint3task10;
@FunctionalInterface
// с аннотацией компилятор проверит, что интерфейс и правда является функциональным,
// т.е. имеет ровно один абстрактный метод.
public interface ExceptionHandler <Exception> {
    void handlingWithException(Exception ohNo);

}

