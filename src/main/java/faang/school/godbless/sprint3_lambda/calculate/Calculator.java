package faang.school.godbless.sprint3_lambda.calculate;

// generics пишем, если нужен объекта любого типа + прописываем методы под generics<T>
// if знаем какой тип использовать, то generics не нужны
public interface Calculator {
    Integer apply(Integer param1, Integer param2);
}
