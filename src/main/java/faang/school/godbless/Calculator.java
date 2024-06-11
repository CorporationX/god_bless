package faang.school.godbless;
//Создать подходящий функциональный интерфейс Calculator, который должен иметь метод, принимающий два значения одного типа
// возвращающий результат применения к ним какой-либо операции.
// Какого типа получится тогда результат?
@FunctionalInterface
public interface Calculator {
    Integer operation(Integer a, Integer b);
}
