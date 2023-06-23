package sprint3task10;
@FunctionalInterface
// с аннотацией компилятор проверит, что интерфейс и правда является функциональным,
// т.е. имеет ровно один абстрактный метод.
public interface ExceptionHandler <Exception> {
    void handlingWithException(Exception ohNo);

}

@FunctionalInterface
public interface Consumer<T> {
    void accept(T param);
}

    // Лямбда – потребим данные, и выведем в консоль
    Consumer<Object> consumer = param -> {
        System.out.println("Consumed – " + param.toString());
    };

// Передадим значение в объект Consumer и вызовем метод accept()
consumer.accept("Hello world!"); // выводит "Consumed – Hello world!"
