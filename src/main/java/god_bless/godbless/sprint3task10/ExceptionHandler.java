package god_bless.godbless.sprint3task10;
@FunctionalInterface
// с аннотацией компилятор проверит, что интерфейс и правда является функциональным,
// т.е. имеет ровно один абстрактный метод.
public interface ExceptionHandler <T> {
    T handlingWithException(Exception ohNo);

}

